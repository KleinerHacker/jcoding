package org.pcsoft.framework.jcoding.processor.implementation.java;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.JTypeReferenceDescriptor;
import org.pcsoft.framework.jcoding.processor.JCodingImportManagement;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

import java.util.List;

/**
 * Created by Christoph on 14.12.2015.
 */
public final class JCodingJavaImportManager extends JCodingImportManagement {

    public JCodingJavaImportManager(String namespace) {
        super(namespace);
    }

    @Override
    protected String extractNamespaceFromType(JTypeReferenceDescriptor referenceDescriptor) {
        return referenceDescriptor.getFullClassName(JClassNamePresentation.Canonical);
    }

    @Override
    protected boolean needImport(String newNamespace, String currentNamespace) {
        if (newNamespace == null || newNamespace.trim().isEmpty())
            return false;

        final String packageCanonicalName = ClassUtils.getPackageCanonicalName(newNamespace);
        if (packageCanonicalName == null || packageCanonicalName.trim().isEmpty()) {
            return false;
        }

        return !newNamespace.equals(currentNamespace);
    }

    @Override
    protected String buildImportCode(List<String> importList) throws JCodingException {
        final StringBuilder sb = new StringBuilder();
        for (final String fullClassName : importList) {
            sb.append("import ").append(fullClassName).append(";").append(SystemUtils.LINE_SEPARATOR);
        }

        return sb.toString();
    }
}
