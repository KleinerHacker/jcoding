package org.pcsoft.framework.jcoding.processor;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.JAnnotationDescriptor;
import org.pcsoft.framework.jcoding.jobject.JAnnotationMethodDescriptor;
import org.pcsoft.framework.jcoding.jobject.JClassDescriptor;
import org.pcsoft.framework.jcoding.jobject.JEnumerationDescriptor;
import org.pcsoft.framework.jcoding.jobject.JFileDescriptor;
import org.pcsoft.framework.jcoding.jobject.JInterfaceDescriptor;
import org.pcsoft.framework.jcoding.jobject.JStandardMethodDescriptor;
import org.pcsoft.framework.jcoding.management.ImportManagement;

/**
 * Represent the core of java cosing framework. In this class all the java code is generated with help of much methods.
 */
final class JCodingJavaProcessor extends JCodingProcessorBase {

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
    protected void buildAnnotationType(final int level, final StringBuilder sb, final ImportManagement importManagement, final JAnnotationDescriptor annotationDescriptor, JBodyBuilderCallback callback) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(annotationDescriptor.getVisibility())).append(" ");
        if (annotationDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("@interface ").append(annotationDescriptor.getName()).append(" {").append(SystemUtils.LINE_SEPARATOR);

        callback.buildBody();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    @Override
    protected void buildEnumerationType(final int level, final StringBuilder sb, final ImportManagement importManagement, final JEnumerationDescriptor enumerationDescriptor, JBodyBuilderCallback callback) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(enumerationDescriptor.getVisibility())).append(" ");
        if (enumerationDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("enum ").append(enumerationDescriptor.getName()).append(" {").append(SystemUtils.LINE_SEPARATOR);

        callback.buildBody();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    @Override
    protected void buildInterfaceType(final int level, final StringBuilder sb, final ImportManagement importManagement, final JInterfaceDescriptor interfaceDescriptor, JBodyBuilderCallback callback) throws JCodingException {
        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(interfaceDescriptor.getVisibility())).append(" ");
        if (interfaceDescriptor.isStatic()) {
            sb.append("static ");
        }
        sb.append("interface ").append(interfaceDescriptor.getName()).append(" {").append(SystemUtils.LINE_SEPARATOR);

        callback.buildBody();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }

    @Override
    protected void buildClassType(final int level, final StringBuilder sb, final ImportManagement importManagement, final JClassDescriptor classDescriptor, JBodyBuilderCallback callback) throws JCodingException {
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
        sb.append("class ").append(classDescriptor.getName()).append(" {").append(SystemUtils.LINE_SEPARATOR);

        callback.buildBody();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }
    //endregion

    //region Methods
    @Override
    protected void buildAnnotationMethod(final int level, final StringBuilder sb, final ImportManagement importManagement, final JAnnotationMethodDescriptor methodDescriptor) {
        importManagement.add(methodDescriptor.getReturnTypeDescriptor().getFullClassName());

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
    protected void buildStandardMethod(final int level, final StringBuilder sb, final ImportManagement importManagement, final JStandardMethodDescriptor methodDescriptor, final JBodyBuilderCallback callback) throws JCodingException {
        importManagement.add(methodDescriptor.getReturnTypeDescriptor().getFullClassName());

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append(JCodingJavaProcessorUtils.convert(methodDescriptor.getVisibility())).append(" ");
        if (methodDescriptor.isStatic()) {
            sb.append("static ");
        } else if (methodDescriptor.isAbstract() || methodDescriptor.getBody() == null) {
            sb.append("abstract ");
        }
        sb.append(methodDescriptor.getReturnTypeDescriptor() != null ? methodDescriptor.getReturnTypeDescriptor().getSimpleClassName() : "void").append(" ");
        sb.append(methodDescriptor.getName()).append("(");
        //TODO: Parameter
        sb.append(") {").append(SystemUtils.LINE_SEPARATOR);

        callback.buildBody();

        sb.append(JCodingProcessorUtils.buildIndent(level));
        sb.append("}").append(SystemUtils.LINE_SEPARATOR);
    }
    //endregion
}
