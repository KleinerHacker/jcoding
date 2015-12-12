package org.pcsoft.framework.jcoding.processor;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.*;
import org.pcsoft.framework.jcoding.management.ImportManagement;
import org.pcsoft.framework.jcoding.type.JBrace;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

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

    @Override
    public final String generateCode(JFileDescriptor fileDescriptor) throws JCodingException {
        fileDescriptor.validate();

        final ImportManagement importManagement = new ImportManagement();
        final StringBuilder sb = new StringBuilder();
        buildFile(sb, importManagement, fileDescriptor);

        return sb.toString().replace(IMPORT_PLACEHOLDER, importManagement.buildImportList());
    }

    private void buildFile(final StringBuilder sb, final ImportManagement importManagement, final JFileDescriptor fileDescriptor) throws JCodingException {
        sb.append(buildNamespace(fileDescriptor));
        sb.append(SystemUtils.LINE_SEPARATOR);

        //Import Place Holder
        sb.append(IMPORT_PLACEHOLDER).append(SystemUtils.LINE_SEPARATOR);
        sb.append(SystemUtils.LINE_SEPARATOR);

        buildTypes(0, sb, importManagement, fileDescriptor.getTypeDescriptors());
    }

    //region Types
    private void buildTypes(final int level, final StringBuilder sb, final ImportManagement importManagement, final JTypeDescriptor[] typeDescriptors) throws JCodingException {
        for (final JTypeDescriptor typeDescriptor : typeDescriptors) {
            buildType(level, sb, importManagement, typeDescriptor);
        }
    }

    private void buildType(final int level, final StringBuilder sb, final ImportManagement importManagement, final JTypeDescriptor typeDescriptor) throws JCodingException {
        typeDescriptor.validate();

        final JBuildCallback superClassBuilder = () -> {
            if (typeDescriptor instanceof JClassDescriptor) {
                buildSuperClassExtension(sb, importManagement, ((JClassDescriptor)typeDescriptor).getSuperClass());
            }
        };
        final JBuildCallback interfacesBuilder = () -> {
            if (typeDescriptor instanceof JClassDescriptor) {
                buildInterfacesImplementation(sb, importManagement, ((JClassDescriptor)typeDescriptor).getInterfaces());
            } else if (typeDescriptor instanceof JInterfaceDescriptor) {
                buildInterfacesImplementation(sb, importManagement, ((JInterfaceDescriptor)typeDescriptor).getInterfaces());
            }
        };
        final JBuildCallback genericBuilder = () -> {
            if (typeDescriptor instanceof JInheritableTypeDescriptor) {
                buildGenerics(sb, importManagement, ((JInheritableTypeDescriptor)typeDescriptor).getGenerics());
            }
        };
        final JBuildCallback bodyBuilder = () -> {
            buildTypes(level + 1, sb, importManagement, typeDescriptor.getChildTypes());
            buildMethods(level + 1, sb, importManagement, typeDescriptor.getMethods());
        };

        if (typeDescriptor instanceof JAnnotationDescriptor) {
            buildAnnotationType(level, sb, importManagement, (JAnnotationDescriptor) typeDescriptor, bodyBuilder);
        } else if (typeDescriptor instanceof JEnumerationDescriptor) {
            buildEnumerationType(level, sb, importManagement, (JEnumerationDescriptor) typeDescriptor, bodyBuilder);
        } else if (typeDescriptor instanceof JInterfaceDescriptor) {
            buildInterfaceType(level, sb, importManagement, (JInterfaceDescriptor) typeDescriptor, bodyBuilder, genericBuilder, interfacesBuilder);
        } else if (typeDescriptor instanceof JClassDescriptor) {
            buildClassType(level, sb, importManagement, (JClassDescriptor) typeDescriptor, bodyBuilder, genericBuilder, superClassBuilder, interfacesBuilder);
        } else
            throw new RuntimeException();
    }
    //endregion

    //region Generics
    private void buildGenerics(final StringBuilder sb, final ImportManagement importManagement, final JGenericDescriptor[] descriptors) throws JCodingException {
        sb.append(getGenericBrace(JBrace.Open));
        for (final JGenericDescriptor descriptor : descriptors) {
            _buildGeneric(sb, importManagement, descriptor);
        }
        sb.append(getGenericBrace(JBrace.Close));
    }

    private void _buildGeneric(final StringBuilder sb, final ImportManagement importManagement, final JGenericDescriptor descriptor) throws JCodingException {
        descriptor.validate();
        if (descriptor.getClassExtension() != null) {
            importManagement.add(descriptor.getClassExtension().getFullClassName(JClassNamePresentation.Canonical));
        }
        for (final JTypeReferenceDescriptor referenceDescriptor : descriptor.getInterfaceExtensions()) {
            importManagement.add(referenceDescriptor.getFullClassName(JClassNamePresentation.Canonical));
        }

        buildGeneric(sb, importManagement, descriptor);
    }
    //endregion

    //region Methods
    private void buildMethods(final int level, final StringBuilder sb, final ImportManagement importManagement, final JMethodDescriptor[] methodDescriptors) throws JCodingException {
        for (final JMethodDescriptor methodDescriptor : methodDescriptors) {
            buildMethod(level, sb, importManagement, methodDescriptor);
        }
    }

    private void buildMethod(final int level, final StringBuilder sb, final ImportManagement importManagement, final JMethodDescriptor methodDescriptor) throws JCodingException {
        methodDescriptor.validate();
        if (methodDescriptor instanceof JAnnotationMethodDescriptor) {
            buildAnnotationMethod(level, sb, importManagement, (JAnnotationMethodDescriptor) methodDescriptor);
        } else if (methodDescriptor instanceof JStandardMethodDescriptor) {
            buildStandardMethod(level, sb, importManagement, (JStandardMethodDescriptor) methodDescriptor,
                    () -> buildMethodBody(level + 1, sb, importManagement, ((JStandardMethodDescriptor) methodDescriptor).getBody()));
        } else
            throw new RuntimeException();
    }
    //endregion

    private static void buildMethodBody(final int level, final StringBuilder sb, final ImportManagement importManagement, JMethodBodyDescriptor bodyDescriptor) {

    }

    /**
     * Build namespace or package name
     *
     * @param fileDescriptor
     * @return
     * @throws JCodingException
     */
    protected abstract String buildNamespace(JFileDescriptor fileDescriptor) throws JCodingException;

    protected abstract void buildSuperClassExtension(StringBuilder sb, ImportManagement importManagement, JClassReferenceDescriptor referenceDescriptor);
    protected abstract void buildInterfacesImplementation(StringBuilder sb, ImportManagement importManagement, JInterfaceReferenceDescriptor[] referenceDescriptors);
    protected abstract void buildClassType(int level, StringBuilder sb, ImportManagement importManagement, JClassDescriptor typeDescriptor, JBuildCallback bodyBuilderCallback, JBuildCallback genericBuilderCallback, JBuildCallback superClassBuilderCallback, JBuildCallback interfacesBuilderCallback) throws JCodingException;

    protected abstract void buildInterfaceType(int level, StringBuilder sb, ImportManagement importManagement, JInterfaceDescriptor typeDescriptor, JBuildCallback bodyBuilderCallback, JBuildCallback genericBuilderCallback, JBuildCallback extensionBuilderCallback) throws JCodingException;

    protected abstract void buildEnumerationType(int level, StringBuilder sb, ImportManagement importManagement, JEnumerationDescriptor typeDescriptor, JBuildCallback bodyBuilderCallback) throws JCodingException;

    protected abstract void buildAnnotationType(int level, StringBuilder sb, ImportManagement importManagement, JAnnotationDescriptor typeDescriptor, JBuildCallback bodyBuilderCallback) throws JCodingException;

    protected abstract void buildStandardMethod(int level, StringBuilder sb, ImportManagement importManagement, JStandardMethodDescriptor methodDescriptor, JBuildCallback callback) throws JCodingException;

    protected abstract void buildAnnotationMethod(int level, StringBuilder sb, ImportManagement importManagement, JAnnotationMethodDescriptor methodDescriptor) throws JCodingException;

    protected abstract String getGenericBrace(JBrace brace) throws JCodingException;

    protected abstract void buildGeneric(StringBuilder sb, ImportManagement importManagement, JGenericDescriptor genericDescriptor) throws JCodingException;
}
