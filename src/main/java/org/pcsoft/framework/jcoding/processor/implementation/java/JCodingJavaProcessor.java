package org.pcsoft.framework.jcoding.processor.implementation.java;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.*;
import org.pcsoft.framework.jcoding.processor.JCodingProcessorBase;
import org.pcsoft.framework.jcoding.processor.JCodingProcessorUtils;
import org.pcsoft.framework.jcoding.type.JBrace;

/**
 * Represent the core of java cosing framework. In this class all the java code is generated with help of much methods.
 */
final class JCodingJavaProcessor extends JCodingProcessorBase {

    public JCodingJavaProcessor() {
        super(JCodingJavaImportManager.class);
    }

    @Override
    protected String buildNamespace(JFileDescriptor fileDescriptor) {
        if (fileDescriptor.getPackageName() != null && !fileDescriptor.getPackageName().trim().isEmpty()) {
            return "package " + fileDescriptor.getPackageName() + ";" + SystemUtils.LINE_SEPARATOR;
        } else {
            return "// Default package" + SystemUtils.LINE_SEPARATOR;
        }
    }

    //region Types
    @Override
    protected void buildAnnotationType(final int level, final StringBuilder sb, final JAnnotationDescriptor annotationDescriptor, JBuildCallback callback) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(annotationDescriptor.getVisibility())).append(" ");
        if (annotationDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("@interface ").append(annotationDescriptor.getName()).append(" {").append(SystemUtils.LINE_SEPARATOR);

        callback.build();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    @Override
    protected void buildEnumerationType(final int level, final StringBuilder sb, final JEnumerationDescriptor enumerationDescriptor, JBuildCallback callback) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(enumerationDescriptor.getVisibility())).append(" ");
        if (enumerationDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("enum ").append(enumerationDescriptor.getName()).append(" {").append(SystemUtils.LINE_SEPARATOR);

        callback.build();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    @Override
    protected void buildInterfaceType(final int level, final StringBuilder sb,
                                      final JInterfaceDescriptor interfaceDescriptor, JBuildCallback bodyBuildCallback,
                                      JBuildCallback genericBuilderCallback,
                                      JBuildCallback interfacesBuilderCallback) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(interfaceDescriptor.getVisibility())).append(" ");
        if (interfaceDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("interface ").append(interfaceDescriptor.getName());
        genericBuilderCallback.build();
        sb.append(" ");
        interfacesBuilderCallback.build();
        sb.append(" {").append(SystemUtils.LINE_SEPARATOR);

        bodyBuildCallback.build();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    @Override
    protected void buildClassType(final int level, final StringBuilder sb,
                                  final JClassDescriptor classDescriptor, JBuildCallback bodyBuildCallback,
                                  JBuildCallback genericBuilderCallback, JBuildCallback superClassBuilderCallback,
                                  JBuildCallback interfacesBuilderCallback) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(classDescriptor.getVisibility())).append(" ");
        if (classDescriptor.isStatic()) {
            sb.append("static ");
        }
        if (classDescriptor.isAbstract()) {
            sb.append("abstract ");
        } else if (classDescriptor.isFinal()) {
            sb.append("final ");
        }
        sb.append("class ").append(classDescriptor.getName());
        genericBuilderCallback.build();
        sb.append(" ");
        superClassBuilderCallback.build();
        sb.append(" ");
        interfacesBuilderCallback.build();
        sb.append(" {").append(SystemUtils.LINE_SEPARATOR);

        bodyBuildCallback.build();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    @Override
    protected void buildSuperClassExtension(StringBuilder sb, JClassReferenceDescriptor referenceDescriptor) {
        sb.append("extends ").append(referenceDescriptor.getSimpleClassName());
    }

    @Override
    protected void buildInterfacesImplementation(StringBuilder sb, JInterfaceReferenceDescriptor[] referenceDescriptors) {
        sb.append("implements ");
        for (final JInterfaceReferenceDescriptor descriptor : referenceDescriptors) {
            sb.append(descriptor.getSimpleClassName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
    }

    //endregion

    //region Methods
    @Override
    protected void buildAnnotationMethod(final int level, final StringBuilder sb, final JAnnotationMethodDescriptor methodDescriptor) {

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(methodDescriptor.getReturnTypeDescriptor() != null ? methodDescriptor.getReturnTypeDescriptor().getSimpleClassName() : "void").append(" ");
        sb.append(methodDescriptor.getName()).append("()");
        if (methodDescriptor.getDefaultValue() != null) {
            sb.append(" default ");
            //TODO: Value
        }
        sb.append(";").append(SystemUtils.LINE_SEPARATOR);
    }

    @Override
    protected void buildStandardMethod(final int level, final StringBuilder sb, final JStandardMethodDescriptor methodDescriptor, final JBuildCallback bodyBuildCallback, final JBuildCallback parameterBuildCallback) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(methodDescriptor.getVisibility())).append(" ");
        if (methodDescriptor.isStatic()) {
            sb.append("static ");
        } else if (methodDescriptor.isAbstract() || methodDescriptor.getBody() == null) {
            sb.append("abstract ");
        }
        sb.append(methodDescriptor.getReturnTypeDescriptor() != null ? methodDescriptor.getReturnTypeDescriptor().getSimpleClassName() : "void").append(" ");
        sb.append(methodDescriptor.getName());
        parameterBuildCallback.build();
        if (!methodDescriptor.isAbstract()) {
            sb.append(" {").append(SystemUtils.LINE_SEPARATOR);

            bodyBuildCallback.build();

            sb.append(JCodingProcessorUtils.buildIndent(level));
            sb.append("}").append(SystemUtils.LINE_SEPARATOR);
        } else {
            sb.append(";").append(SystemUtils.LINE_SEPARATOR);
        }
    }
    //endregion


    //region Method Parameter
    @Override
    protected void buildParameter(StringBuilder sb, JParameterDescriptor parameterDescriptor) throws JCodingException {
        if (parameterDescriptor.isFinal()) {
            sb.append("final ");
        }
        sb.append(parameterDescriptor.getType().getSimpleClassName()).append(" ").append(parameterDescriptor.getName());
    }

    @Override
    protected String getMethodParameterSeparator() {
        return ", ";
    }

    @Override
    protected String getMethodParameterBrace(JBrace brace) {
        switch (brace) {
            case Open:
                return "(";
            case Close:
                return ")";
            default:
                throw new RuntimeException();
        }
    }
    //endregion

    //region Generics
    @Override
    protected String getGenericBrace(JBrace brace) {
        switch (brace) {
            case Open:
                return "<";
            case Close:
                return ">";
            default:
                throw new RuntimeException();
        }
    }

    @Override
    protected String getGenericSeparator() {
        return ",";
    }

    @Override
    protected void buildGeneric(StringBuilder sb, JGenericDescriptor genericDescriptor) throws JCodingException {
        sb.append(genericDescriptor.getName());
        if (genericDescriptor.getClassExtension() != null || genericDescriptor.getInterfaceExtensions().length > 0) {
            sb.append(" extends ");
            if (genericDescriptor.getClassExtension() != null) {
                sb.append(genericDescriptor.getClassExtension().getSimpleClassName());
                if (genericDescriptor.getInterfaceExtensions().length > 0) {
                    sb.append(" & ");
                }
            }
            if (genericDescriptor.getInterfaceExtensions().length > 0) {
                for (final JTypeReferenceDescriptorBase referenceDescriptor : genericDescriptor.getInterfaceExtensions()) {
                    sb.append(referenceDescriptor.getSimpleClassName()).append(" &");
                }
                sb.delete(sb.length() - 2, sb.length());
            }
        }
    }
    //endregion
}
