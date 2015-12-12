package org.pcsoft.framework.jcoding.processor;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.JAnnotationDescriptor;
import org.pcsoft.framework.jcoding.jobject.JAnnotationMethodDescriptor;
import org.pcsoft.framework.jcoding.jobject.JClassDescriptor;
import org.pcsoft.framework.jcoding.jobject.JEnumerationDescriptor;
import org.pcsoft.framework.jcoding.jobject.JFileDescriptor;
import org.pcsoft.framework.jcoding.jobject.JInterfaceDescriptor;
import org.pcsoft.framework.jcoding.jobject.JMethodBodyDescriptor;
import org.pcsoft.framework.jcoding.jobject.JMethodDescriptor;
import org.pcsoft.framework.jcoding.jobject.JStandardMethodDescriptor;
import org.pcsoft.framework.jcoding.jobject.JTypeDescriptor;
import org.pcsoft.framework.jcoding.management.ImportManagement;

/**
 * Basic implementation for code generation
 */
public abstract class JCodingProcessorBase implements JCodingProcessor {
    private static final String IMPORT_PLACEHOLDER = "$$IMPORT$$";

    /**
     * Callback for Body Generation
     */
    @FunctionalInterface
    public static interface JBodyBuilderCallback {
        /**
         * Call this method on a callback object to build the body on this position in string builder.
         * @throws JCodingException
         */
        void buildBody() throws JCodingException;
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

        final JBodyBuilderCallback bodyBuilder = () -> {
            buildTypes(level + 1, sb, importManagement, typeDescriptor.getChildTypes());
            buildMethods(level + 1, sb, importManagement, typeDescriptor.getMethods());
        };

        if (typeDescriptor instanceof JAnnotationDescriptor) {
            buildAnnotationType(level, sb, importManagement, (JAnnotationDescriptor) typeDescriptor, bodyBuilder);
        } else if (typeDescriptor instanceof JEnumerationDescriptor) {
            buildEnumerationType(level, sb, importManagement, (JEnumerationDescriptor) typeDescriptor, bodyBuilder);
        } else if (typeDescriptor instanceof JInterfaceDescriptor) {
            buildInterfaceType(level, sb, importManagement, (JInterfaceDescriptor) typeDescriptor, bodyBuilder);
        } else if (typeDescriptor instanceof JClassDescriptor) {
            buildClassType(level, sb, importManagement, (JClassDescriptor) typeDescriptor, bodyBuilder);
        } else
            throw new RuntimeException();
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
                    () -> buildMethodBody(level + 1, sb, importManagement, ((JStandardMethodDescriptor)methodDescriptor).getBody()));
        } else
            throw new RuntimeException();
    }
    //endregion

    private static void buildMethodBody(final int level, final StringBuilder sb, final ImportManagement importManagement, JMethodBodyDescriptor bodyDescriptor) {

    }

    /**
     * Build namespace or package name
     * @param fileDescriptor
     * @return
     * @throws JCodingException
     */
    protected abstract String buildNamespace(JFileDescriptor fileDescriptor) throws JCodingException;

    protected abstract void buildClassType(int level, StringBuilder sb, ImportManagement importManagement, JClassDescriptor typeDescriptor, JBodyBuilderCallback buildBody)  throws JCodingException ;
    protected abstract void buildInterfaceType(int level, StringBuilder sb, ImportManagement importManagement, JInterfaceDescriptor typeDescriptor, JBodyBuilderCallback buildBody) throws JCodingException;
    protected abstract void buildEnumerationType(int level, StringBuilder sb, ImportManagement importManagement, JEnumerationDescriptor typeDescriptor, JBodyBuilderCallback buildBody) throws JCodingException;
    protected abstract void buildAnnotationType(int level, StringBuilder sb, ImportManagement importManagement, JAnnotationDescriptor typeDescriptor, JBodyBuilderCallback buildBody) throws JCodingException;

    protected abstract void buildStandardMethod(int level, StringBuilder sb, ImportManagement importManagement, JStandardMethodDescriptor methodDescriptor, JBodyBuilderCallback callback) throws JCodingException;
    protected abstract void buildAnnotationMethod(int level, StringBuilder sb, ImportManagement importManagement, JAnnotationMethodDescriptor methodDescriptor) throws JCodingException;
}
