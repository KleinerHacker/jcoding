package org.pcsoft.framework.jcoding.processor.implementation.java;

import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.JExternalTypeReferenceDescriptor;
import org.pcsoft.framework.jcoding.jobject.JInternalTypeReferenceDescriptor;
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
    protected String extractNamespaceFromInternalType(JInternalTypeReferenceDescriptor referenceDescriptor) {
        return referenceDescriptor.getFullClassName(JClassNamePresentation.Canonical);
    }

    @Override
    protected String extractNamespaceFromExternalType(JExternalTypeReferenceDescriptor referenceDescriptor) {
        return referenceDescriptor.getFullClassName(JClassNamePresentation.Canonical);
    }

    @Override
    protected boolean needImport(String newNamespace, String currentNamespace) {
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
