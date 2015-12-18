package org.pcsoft.framework.jcoding.processor;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.SystemUtils;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.JGenericReferenceDescriptor;
import org.pcsoft.framework.jcoding.jobject.JReferenceDescriptor;
import org.pcsoft.framework.jcoding.jobject.JTypeReferenceDescriptor;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the import manager vase implementation to handle all imports for a code file.
 */
public final class JCodingImportManagement {
    private final List<String> importList = new ArrayList<>();
    private final String packageName;

    public JCodingImportManagement(String packageName) {
        this.packageName = packageName;
    }

    public String buildImportList() throws JCodingException {
        return buildImportCode(importList);
    }

    /**
     * Register all reference types and add it to import list
     * @param referenceDescriptors
     */
    public final <T extends JReferenceDescriptor>void registerTypes(T[] referenceDescriptors) {
        for (final JReferenceDescriptor referenceDescriptor : referenceDescriptors) {
            registerType(referenceDescriptor);
        }
    }

    /**
     * Register the reference type and add it to import list.
     * @param referenceDescriptor
     */
    public final void registerType(JReferenceDescriptor referenceDescriptor) {
        if (referenceDescriptor == null)
            throw new IllegalArgumentException("descriptor must be set!");

        final String newNamespace;
        if (referenceDescriptor instanceof JTypeReferenceDescriptor) {
            newNamespace = extractNamespaceFromType((JTypeReferenceDescriptor) referenceDescriptor);
        } else if (referenceDescriptor instanceof JGenericReferenceDescriptor) {
            newNamespace = null;
        } else
            throw new RuntimeException("Unknown reference class: " + referenceDescriptor.getClass());

        if (newNamespace == null || importList.contains(newNamespace))
            return;
        if (!needImport(newNamespace, packageName))
            return;

        importList.add(newNamespace);
    }

    /**
     * Extract a namespace from internal type
     * @param referenceDescriptor
     * @return New namespace to import. Will be checked with {@link #needImport(String, String)}
     */
    private String extractNamespaceFromType(JTypeReferenceDescriptor referenceDescriptor) {
        return referenceDescriptor.getFullClassName(JClassNamePresentation.Canonical);
    }

    /**
     * Check that the new namespace is needed, based on current used namespace for this code file.
     * @param newNamespace New namespace to add
     * @param currentNamespace Current namespace in file
     * @return TRUE to add new namespace, otherwise FALSE
     */
    private boolean needImport(final String newNamespace, final String currentNamespace) {
        if (newNamespace == null || newNamespace.trim().isEmpty())
            return false;

        final String packageCanonicalName = ClassUtils.getPackageCanonicalName(newNamespace);
        if (packageCanonicalName == null || packageCanonicalName.trim().isEmpty()) {
            return false;
        }

        return !newNamespace.equals(currentNamespace);
    }

    private String buildImportCode(final List<String> importList) throws JCodingException {
        final StringBuilder sb = new StringBuilder();
        for (final String fullClassName : importList) {
            sb.append("import ").append(fullClassName).append(";").append(SystemUtils.LINE_SEPARATOR);
        }

        return sb.toString();
    }
}
