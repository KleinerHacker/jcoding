package org.pcsoft.framework.jcoding.processor;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.exception.JCodingGenerationException;
import org.pcsoft.framework.jcoding.jobject.*;
import org.pcsoft.framework.jcoding.type.JBrace;

import java.lang.reflect.InvocationTargetException;

/**
 * Basic implementation for code generation
 */
public abstract class JCodingProcessorBase implements JCodingProcessor {
    private static final String IMPORT_PLACEHOLDER = "$$IMPORT$$";

    /**
     * Callback for Generation
     */
    @FunctionalInterface
    public static interface JBuildCallback {
        /**
         * Call this method on a callback object to build on this position in string builder.
         *
         * @throws JCodingException
         */
        void build() throws JCodingException;
    }

    private final Class<? extends JCodingImportManagement> importManagerClass;

    public JCodingProcessorBase(final Class<? extends JCodingImportManagement> importManagerClass) {
        this.importManagerClass = importManagerClass;
    }

    @Override
    public final String generateCode(JFileDescriptor fileDescriptor) throws JCodingException {
        fileDescriptor.validate();

        final JCodingImportManagement importManagement;
        try {
            importManagement = importManagerClass.getConstructor(String.class).newInstance(fileDescriptor.getPackageName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new JCodingGenerationException("Unable to initialize import manager!", e);
        }
        final StringBuilder sb = new StringBuilder();
        buildFile(sb, importManagement, fileDescriptor);

        return sb.toString().replace(IMPORT_PLACEHOLDER, importManagement.buildImportList());
    }

    private void buildFile(final StringBuilder sb, final JCodingImportManagement importManagement, final JFileDescriptor fileDescriptor) throws JCodingException {
        sb.append(buildNamespace(fileDescriptor));
        sb.append(SystemUtils.LINE_SEPARATOR);

        //Import Place Holder
        sb.append(IMPORT_PLACEHOLDER).append(SystemUtils.LINE_SEPARATOR);
        sb.append(SystemUtils.LINE_SEPARATOR);

        buildTypes(0, sb, importManagement, fileDescriptor.getTypeDescriptors());
    }

    //region Types
    private void buildTypes(final int level, final StringBuilder sb, final JCodingImportManagement importManagement, final JTypeDescriptor[] typeDescriptors) throws JCodingException {
        for (final JTypeDescriptor typeDescriptor : typeDescriptors) {
            buildType(level, sb, importManagement, typeDescriptor);
        }
    }

    private void buildType(final int level, final StringBuilder sb, final JCodingImportManagement importManagement, final JTypeDescriptor typeDescriptor) throws JCodingException {
        typeDescriptor.validate();

        final JBuildCallback superClassBuilder = () -> {
            if (typeDescriptor instanceof JClassDescriptor) {
                buildSuperClassExtension(sb, ((JClassDescriptor) typeDescriptor).getSuperClass());
            }
        };
        final JBuildCallback interfacesBuilder = () -> {
            if (typeDescriptor instanceof JClassDescriptor) {
                buildInterfacesImplementation(sb, ((JClassDescriptor) typeDescriptor).getInterfaces());
            } else if (typeDescriptor instanceof JInterfaceDescriptor) {
                buildInterfacesImplementation(sb, ((JInterfaceDescriptor) typeDescriptor).getInterfaces());
            }
        };
        final JBuildCallback genericBuilder = () -> {
            if (typeDescriptor instanceof JInheritableTypeDescriptor) {
                buildGenerics(sb, importManagement, ((JInheritableTypeDescriptor) typeDescriptor).getGenerics());
            }
        };
        final JBuildCallback bodyBuilder = () -> {
            buildTypes(level + 1, sb, importManagement, typeDescriptor.getChildTypes());
            buildMethods(level + 1, sb, importManagement, typeDescriptor.getMethods());
        };

        if (typeDescriptor instanceof JAnnotationDescriptor) {
            final JAnnotationDescriptor annotationDescriptor = (JAnnotationDescriptor) typeDescriptor;
            buildAnnotationType(level, sb, annotationDescriptor, bodyBuilder);
        } else if (typeDescriptor instanceof JEnumerationDescriptor) {
            final JEnumerationDescriptor enumerationDescriptor = (JEnumerationDescriptor) typeDescriptor;
            importManagement.registerTypes(enumerationDescriptor.getInterfaces());
            buildEnumerationType(level, sb, enumerationDescriptor, bodyBuilder);
        } else if (typeDescriptor instanceof JInterfaceDescriptor) {
            final JInterfaceDescriptor interfaceDescriptor = (JInterfaceDescriptor) typeDescriptor;
            importManagement.registerTypes(interfaceDescriptor.getInterfaces());
            buildInterfaceType(level, sb, interfaceDescriptor, bodyBuilder, genericBuilder, interfacesBuilder);
        } else if (typeDescriptor instanceof JClassDescriptor) {
            final JClassDescriptor classDescriptor = (JClassDescriptor) typeDescriptor;
            importManagement.registerType(classDescriptor.getSuperClass());
            importManagement.registerTypes(classDescriptor.getInterfaces());
            buildClassType(level, sb, classDescriptor, bodyBuilder, genericBuilder, superClassBuilder, interfacesBuilder);
        } else
            throw new RuntimeException();
    }
    //endregion

    //region Generics
    private void buildGenerics(final StringBuilder sb, final JCodingImportManagement importManagement, final JGenericDescriptor[] descriptors) throws JCodingException {
        if (descriptors == null || descriptors.length <= 0)
            return;

        sb.append(getGenericBrace(JBrace.Open));
        for (final JGenericDescriptor descriptor : descriptors) {
            _buildGeneric(sb, importManagement, descriptor);
            sb.append(getGenericSeparator());
        }
        sb.delete(sb.length() - getGenericSeparator().length(), sb.length());
        sb.append(getGenericBrace(JBrace.Close));
    }

    private void _buildGeneric(final StringBuilder sb, final JCodingImportManagement importManagement, final JGenericDescriptor descriptor) throws JCodingException {
        descriptor.validate();
        if (descriptor.getClassExtension() != null) {
            importManagement.registerType(descriptor.getClassExtension());
        }
        for (final JTypeReferenceDescriptor referenceDescriptor : descriptor.getInterfaceExtensions()) {
            importManagement.registerType(referenceDescriptor);
        }

        buildGeneric(sb, descriptor);
    }
    //endregion

    //region Methods
    private void buildMethods(final int level, final StringBuilder sb, final JCodingImportManagement importManagement, final JMethodDescriptor[] methodDescriptors) throws JCodingException {
        for (final JMethodDescriptor methodDescriptor : methodDescriptors) {
            buildMethod(level, sb, importManagement, methodDescriptor);
        }
    }

    private void buildMethod(final int level, final StringBuilder sb, final JCodingImportManagement importManagement, final JMethodDescriptor methodDescriptor) throws JCodingException {
        methodDescriptor.validate();

        if (methodDescriptor.getReturnTypeDescriptor() != null) {
            importManagement.registerType(methodDescriptor.getReturnTypeDescriptor());
        }
        if (methodDescriptor instanceof JAnnotationMethodDescriptor) {
            buildAnnotationMethod(level, sb, (JAnnotationMethodDescriptor) methodDescriptor);
        } else if (methodDescriptor instanceof JStandardMethodDescriptor) {
            final JStandardMethodDescriptor standardMethodDescriptor = (JStandardMethodDescriptor) methodDescriptor;
            buildStandardMethod(level, sb, standardMethodDescriptor,
                    () -> buildMethodBody(level + 1, sb, importManagement, standardMethodDescriptor.getBody()),
                    () -> buildParameters(sb, importManagement, standardMethodDescriptor.getParameters()));
        } else
            throw new RuntimeException();

        sb.append(SystemUtils.LINE_SEPARATOR);
    }
    //endregion

    private void buildParameters(final StringBuilder sb, final JCodingImportManagement importManagement, final JParameterDescriptor[] parameterDescriptors) throws JCodingException {
        sb.append(getMethodParameterBrace(JBrace.Open));
        if (parameterDescriptors.length > 0) {
            for (final JParameterDescriptor parameterDescriptor : parameterDescriptors) {
                buildParameter(sb, importManagement, parameterDescriptor);
                sb.append(getMethodParameterSeparator());
            }
            sb.delete(sb.length() - getMethodParameterSeparator().length(), sb.length());
        }
        sb.append(getMethodParameterBrace(JBrace.Close));
    }

    private void buildParameter(final StringBuilder sb, final JCodingImportManagement importManagement, final JParameterDescriptor parameterDescriptor) throws JCodingException {
        importManagement.registerType(parameterDescriptor.getType());
        buildParameter(sb, parameterDescriptor);
    }

    private void buildMethodBody(final int level, final StringBuilder sb, final JCodingImportManagement importManagement, JMethodBodyDescriptor bodyDescriptor) {

    }

    /**
     * Build namespace or package name
     *
     * @param fileDescriptor
     * @return
     * @throws JCodingException
     */
    protected abstract String buildNamespace(JFileDescriptor fileDescriptor) throws JCodingException;

    protected abstract void buildSuperClassExtension(StringBuilder sb, JClassReferenceDescriptor referenceDescriptor);

    protected abstract void buildInterfacesImplementation(StringBuilder sb, JInterfaceReferenceDescriptor[] referenceDescriptors);

    protected abstract void buildClassType(int level, StringBuilder sb, JClassDescriptor typeDescriptor, JBuildCallback bodyBuilderCallback, JBuildCallback genericBuilderCallback, JBuildCallback superClassBuilderCallback, JBuildCallback interfacesBuilderCallback) throws JCodingException;

    protected abstract void buildInterfaceType(int level, StringBuilder sb, JInterfaceDescriptor typeDescriptor, JBuildCallback bodyBuilderCallback, JBuildCallback genericBuilderCallback, JBuildCallback extensionBuilderCallback) throws JCodingException;

    protected abstract void buildEnumerationType(int level, StringBuilder sb, JEnumerationDescriptor typeDescriptor, JBuildCallback bodyBuilderCallback) throws JCodingException;

    protected abstract void buildAnnotationType(int level, StringBuilder sb, JAnnotationDescriptor typeDescriptor, JBuildCallback bodyBuilderCallback) throws JCodingException;

    protected abstract void buildStandardMethod(int level, StringBuilder sb, JStandardMethodDescriptor methodDescriptor, JBuildCallback bodyBuildCallback, JBuildCallback parameterBuilderCallback) throws JCodingException;

    protected abstract void buildAnnotationMethod(int level, StringBuilder sb, JAnnotationMethodDescriptor methodDescriptor) throws JCodingException;

    protected abstract void buildGeneric(StringBuilder sb, JGenericDescriptor genericDescriptor) throws JCodingException;

    protected abstract void buildParameter(StringBuilder sb, JParameterDescriptor parameterDescriptor) throws JCodingException;

    //region Simple Getter
    protected abstract String getGenericBrace(JBrace brace);

    protected abstract String getMethodParameterBrace(JBrace brace);

    protected abstract String getMethodParameterSeparator();

    protected abstract String getGenericSeparator();
    //endregion
}
