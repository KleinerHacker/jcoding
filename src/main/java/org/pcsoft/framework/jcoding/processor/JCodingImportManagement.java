package org.pcsoft.framework.jcoding.processor;

import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.JExternalTypeReferenceDescriptor;
import org.pcsoft.framework.jcoding.jobject.JInternalTypeReferenceDescriptor;
import org.pcsoft.framework.jcoding.jobject.JReferenceDescriptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the import manager vase implementation to handle all imports for a code file.
 */
public abstract class JCodingImportManagement {
    private final List<String> importList = new ArrayList<>();
    private final String namespace;

    public JCodingImportManagement(String namespace) {
        this.namespace = namespace;
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
        if (referenceDescriptor instanceof JInternalTypeReferenceDescriptor) {
            newNamespace = extractNamespaceFromInternalType((JInternalTypeReferenceDescriptor) referenceDescriptor);
        } else if (referenceDescriptor instanceof JExternalTypeReferenceDescriptor) {
            newNamespace = extractNamespaceFromExternalType((JExternalTypeReferenceDescriptor) referenceDescriptor);
        } else
            throw new RuntimeException("Unknown reference class: " + referenceDescriptor.getClass());

        if (importList.contains(newNamespace))
            return;
        if (!needImport(newNamespace, namespace))
            return;

        importList.add(newNamespace);
    }

    /**
     * Extract a namespace from internal type
     * @param referenceDescriptor
     * @return New namespace to import. Will be checked with {@link #needImport(String, String)}
     */
    protected abstract String extractNamespaceFromInternalType(JInternalTypeReferenceDescriptor referenceDescriptor);
    /**
     * Extract a namespace from external type
     * @param referenceDescriptor
     * @return New namespace to import. Will be checked with {@link #needImport(String, String)}
     */
    protected abstract String extractNamespaceFromExternalType(JExternalTypeReferenceDescriptor referenceDescriptor);

    /**
     * Check that the new namespace is needed, based on current used namespace for this code file.
     * @param newNamespace New namespace to add
     * @param currentNamespace Current namespace in file
     * @return TRUE to add new namespace, otherwise FALSE
     */
    protected abstract boolean needImport(final String newNamespace, final String currentNamespace);

    protected abstract String buildImportCode(final List<String> importList) throws JCodingException;
}
