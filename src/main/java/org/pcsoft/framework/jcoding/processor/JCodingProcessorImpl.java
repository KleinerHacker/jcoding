package org.pcsoft.framework.jcoding.processor;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.*;

/**
 * Basic implementation for code generation
 */
final class JCodingProcessorImpl implements JCodingProcessor {
    private static final String IMPORT_PLACEHOLDER = "$$IMPORT$$";

    @Override
    public final String generateCode(JFileDescriptor fileDescriptor) throws JCodingException {
        fileDescriptor.validate();

        final JCodingImportManagement importManagement = new JCodingImportManagement(fileDescriptor.getPackageName());
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

    private String buildNamespace(JFileDescriptor fileDescriptor) {
        if (fileDescriptor.getPackageName() != null && !fileDescriptor.getPackageName().trim().isEmpty()) {
            return "package " + fileDescriptor.getPackageName() + ";" + SystemUtils.LINE_SEPARATOR;
        } else {
            return "// Default package" + SystemUtils.LINE_SEPARATOR;
        }
    }

    //region Types
    private void buildTypes(final int level, final StringBuilder sb, final JCodingImportManagement importManagement, final JTypeDescriptor[] typeDescriptors) throws JCodingException {
        for (final JTypeDescriptor typeDescriptor : typeDescriptors) {
            buildType(level, sb, importManagement, typeDescriptor);
        }
    }

    private void buildType(final int level, final StringBuilder sb, final JCodingImportManagement importManagement, final JTypeDescriptor typeDescriptor) throws JCodingException {
        typeDescriptor.validate();

        if (typeDescriptor instanceof JAnnotationDescriptor) {
            final JAnnotationDescriptor annotationDescriptor = (JAnnotationDescriptor) typeDescriptor;
            buildAnnotationType(level, sb, importManagement, annotationDescriptor);
        } else if (typeDescriptor instanceof JEnumerationDescriptor) {
            final JEnumerationDescriptor enumerationDescriptor = (JEnumerationDescriptor) typeDescriptor;
            importManagement.registerTypes(enumerationDescriptor.getInterfaces());
            buildEnumerationType(level, sb, importManagement, enumerationDescriptor);
        } else if (typeDescriptor instanceof JInterfaceDescriptor) {
            final JInterfaceDescriptor interfaceDescriptor = (JInterfaceDescriptor) typeDescriptor;
            importManagement.registerTypes(interfaceDescriptor.getInterfaces());
            buildInterfaceType(level, sb, importManagement, interfaceDescriptor);
        } else if (typeDescriptor instanceof JClassDescriptor) {
            final JClassDescriptor classDescriptor = (JClassDescriptor) typeDescriptor;
            importManagement.registerType(classDescriptor.getSuperClass());
            importManagement.registerTypes(classDescriptor.getInterfaces());
            buildClassType(level, sb, importManagement, classDescriptor);
        } else
            throw new RuntimeException();
    }

    private void buildClassType(int level, StringBuilder sb, JCodingImportManagement importManagement,
                                JClassDescriptor classDescriptor) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(classDescriptor.getVisibility().getKeyword()).append(" ");
        if (classDescriptor.isStatic()) {
            sb.append("static ");
        }
        if (classDescriptor.isAbstract()) {
            sb.append("abstract ");
        } else if (classDescriptor.isFinal()) {
            sb.append("final ");
        }
        sb.append("class ").append(classDescriptor.getName());
        buildGenerics(sb, importManagement, classDescriptor.getGenerics());
        if (classDescriptor.getSuperClass() != null) {
            sb.append(" extends ");
            buildReference(sb, importManagement, classDescriptor.getSuperClass());
        }
        if (classDescriptor.getInterfaces().length > 0) {
            sb.append(" implements ");
            buildExtensions(sb, importManagement, classDescriptor.getInterfaces());
        }
        sb.append(" {").append(SystemUtils.LINE_SEPARATOR);

        buildMethods(level + 1, sb, importManagement, classDescriptor.getMethods());

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    private void buildInterfaceType(int level, StringBuilder sb, JCodingImportManagement importManagement,
                                    JInterfaceDescriptor interfaceDescriptor) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(interfaceDescriptor.getVisibility().getKeyword()).append(" ");
        if (interfaceDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("interface ").append(interfaceDescriptor.getName());
        buildGenerics(sb, importManagement, interfaceDescriptor.getGenerics());
        sb.append(" ");
        if (interfaceDescriptor.getInterfaces().length > 0) {
            sb.append("extends ");
            buildExtensions(sb, importManagement, interfaceDescriptor.getInterfaces());
        }
        sb.append(" {").append(SystemUtils.LINE_SEPARATOR);

        buildMethods(level + 1, sb, importManagement, interfaceDescriptor.getMethods());

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    private void buildEnumerationType(int level, StringBuilder sb, JCodingImportManagement importManagement,
                                      JEnumerationDescriptor enumerationDescriptor) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(enumerationDescriptor.getVisibility().getKeyword()).append(" ");
        if (enumerationDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("enum ").append(enumerationDescriptor.getName()).append(" {").append(SystemUtils.LINE_SEPARATOR);

        buildMethods(level + 1, sb, importManagement, enumerationDescriptor.getMethods());

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    private void buildAnnotationType(int level, StringBuilder sb, JCodingImportManagement importManagement,
                                     JAnnotationDescriptor annotationDescriptor) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(annotationDescriptor.getVisibility().getKeyword()).append(" ");
        if (annotationDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("@interface ").append(annotationDescriptor.getName()).append(" {").append(SystemUtils.LINE_SEPARATOR);

        buildMethods(level + 1, sb, importManagement, annotationDescriptor.getMethods());

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    private void buildExtensions(StringBuilder sb, JCodingImportManagement importManagement, JTypeReferenceDescriptor[] extensions) throws JCodingException {
        if (extensions == null || extensions.length <= 0)
            return;

        for (final JTypeReferenceDescriptor extension : extensions) {
            buildReference(sb, importManagement, extension);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
    }
    //endregion

    private void buildReference(StringBuilder sb, JCodingImportManagement importManagement, JReferenceDescriptor referenceDescriptor) throws JCodingException {
        referenceDescriptor.validate();
        importManagement.registerType(referenceDescriptor);

        if (referenceDescriptor instanceof JTypeReferenceDescriptor) {
            final JTypeReferenceDescriptor typeReferenceDescriptor = (JTypeReferenceDescriptor) referenceDescriptor;
            sb.append(typeReferenceDescriptor.getSimpleClassName());
            if (referenceDescriptor instanceof JInheritableReferenceDescriptor) {
                final JInheritableReferenceDescriptor inheritableReferenceDescriptor = (JInheritableReferenceDescriptor) referenceDescriptor;
                if (inheritableReferenceDescriptor.getGenerics().length > 0) {
                    buildGenericValues(sb, importManagement, inheritableReferenceDescriptor.getGenerics());
                }
            }
        } else if (referenceDescriptor instanceof JGenericReferenceDescriptor) {
            final JGenericReferenceDescriptor genericReferenceDescriptor = (JGenericReferenceDescriptor) referenceDescriptor;
            sb.append(genericReferenceDescriptor.getGenericReference().getName());
        } else
            throw new RuntimeException("Unknown reference class: " + referenceDescriptor.getClass());
    }

    //region Generics
    private void buildGenerics(final StringBuilder sb, final JCodingImportManagement importManagement, final JGenericDescriptor[] descriptors) throws JCodingException {
        if (descriptors == null || descriptors.length <= 0)
            return;

        sb.append("<");
        for (final JGenericDescriptor descriptor : descriptors) {
            buildGeneric(sb, importManagement, descriptor);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
    }

    private void buildGeneric(final StringBuilder sb, final JCodingImportManagement importManagement, final JGenericDescriptor genericDescriptor) throws JCodingException {
        genericDescriptor.validate();

        sb.append(genericDescriptor.getName());
        if (genericDescriptor.getClassExtension() != null || genericDescriptor.getInterfaceExtensions().length > 0) {
            sb.append(" extends ");
            if (genericDescriptor.getClassExtension() != null) {
                buildReference(sb, importManagement, genericDescriptor.getClassExtension());
                if (genericDescriptor.getInterfaceExtensions().length > 0) {
                    sb.append(" & ");
                }
            }
            if (genericDescriptor.getInterfaceExtensions().length > 0) {
                for (final JTypeReferenceDescriptor referenceDescriptor : genericDescriptor.getInterfaceExtensions()) {
                    buildReference(sb, importManagement, referenceDescriptor);
                    sb.append(" & ");
                }
                sb.delete(sb.length() - 3, sb.length());
            }
        }
    }

    private void buildGenericValues(final StringBuilder sb, final JCodingImportManagement importManagement, JGenericValueDescriptor[] generics) throws JCodingException {
        if (generics == null || generics.length <= 0)
            return;

        sb.append("<");
        for (final JGenericValueDescriptor generic : generics) {
            buildGenericValue(sb, importManagement, generic);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
    }

    private void buildGenericValue(final StringBuilder sb, final JCodingImportManagement importManagement, JGenericValueDescriptor generic) throws JCodingException {
        importManagement.registerType(generic.getReference());
        if (generic.isWildcard()) {
            sb.append("? extends ");
        }
        buildReference(sb, importManagement, generic.getReference());
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
            buildAnnotationMethod(level, sb, importManagement, (JAnnotationMethodDescriptor) methodDescriptor);
        } else if (methodDescriptor instanceof JStandardMethodDescriptor) {
            final JStandardMethodDescriptor standardMethodDescriptor = (JStandardMethodDescriptor) methodDescriptor;
            buildStandardMethod(level, sb, importManagement, standardMethodDescriptor);
        } else
            throw new RuntimeException();

        sb.append(SystemUtils.LINE_SEPARATOR);
    }

    private void buildStandardMethod(int level, StringBuilder sb, JCodingImportManagement importManagement,
                                     JStandardMethodDescriptor methodDescriptor) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(methodDescriptor.getVisibility().getKeyword()).append(" ");
        if (methodDescriptor.isStatic()) {
            sb.append("static ");
        } else if (methodDescriptor.isAbstract() || methodDescriptor.getBody() == null) {
            sb.append("abstract ");
        }
        buildGenerics(sb, importManagement, methodDescriptor.getGenerics());
        if (methodDescriptor.getReturnTypeDescriptor() != null) {
            buildReference(sb, importManagement, methodDescriptor.getReturnTypeDescriptor());
        } else {
            sb.append("void");
        }
        sb.append(" ");
        sb.append(methodDescriptor.getName());
        buildParameters(sb, importManagement, methodDescriptor.getParameters());
        sb.append(" ");
        buildThrows(sb, importManagement, methodDescriptor.getThrows());
        if (!methodDescriptor.isAbstract()) {
            sb.append(" {").append(SystemUtils.LINE_SEPARATOR);

            buildMethodBody(level + 1, sb, importManagement, methodDescriptor.getBody());

            sb.append(JCodingProcessorUtils.buildIndent(level));
            sb.append("}").append(SystemUtils.LINE_SEPARATOR);
        } else {
            sb.append(";").append(SystemUtils.LINE_SEPARATOR);
        }
    }

    private void buildThrows(StringBuilder sb, JCodingImportManagement importManagement, JClassReferenceDescriptor[] $throws) throws JCodingException {
        if ($throws == null || $throws.length <= 0)
            return;

        sb.append("throws ");
        for (final JClassReferenceDescriptor $throw : $throws) {
            buildReference(sb, importManagement, $throw);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
    }

    private void buildAnnotationMethod(int level, StringBuilder sb, JCodingImportManagement importManagement, JAnnotationMethodDescriptor methodDescriptor) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        if (methodDescriptor.getReturnTypeDescriptor() != null) {
            buildReference(sb, importManagement, methodDescriptor.getReturnTypeDescriptor());
        } else {
            sb.append("void");
        }
        sb.append(" ");
        sb.append(methodDescriptor.getName()).append("()");
        if (methodDescriptor.getDefaultValue() != null) {
            sb.append(" default ");
            //TODO: Value
        }
        sb.append(";").append(SystemUtils.LINE_SEPARATOR);
    }
    //endregion

    //region Parameters
    private void buildParameters(final StringBuilder sb, final JCodingImportManagement importManagement, final JParameterDescriptor[] parameterDescriptors) throws JCodingException {
        sb.append("(");
        if (parameterDescriptors.length > 0) {
            for (final JParameterDescriptor parameterDescriptor : parameterDescriptors) {
                buildParameter(sb, importManagement, parameterDescriptor);
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(")");
    }

    private void buildParameter(final StringBuilder sb, final JCodingImportManagement importManagement, final JParameterDescriptor parameterDescriptor) throws JCodingException {
        parameterDescriptor.validate();

        if (parameterDescriptor.isFinal()) {
            sb.append("final ");
        }
        buildReference(sb, importManagement, parameterDescriptor.getReference());
        sb.append(" ").append(parameterDescriptor.getName());
    }
    //endregion

    private void buildMethodBody(final int level, final StringBuilder sb, final JCodingImportManagement importManagement, JMethodBodyDescriptor bodyDescriptor) {

    }
}
