package org.pcsoft.framework.jcoding.jobject.type;

/**
 * Representtation of external interface reference. To create see {@link JInterfaceReference}
 */
public final class JExternalInterfaceReference extends JExternalTypeReference implements JInterfaceReference {

    JExternalInterfaceReference(String fullReferenceClassName) {
        super(fullReferenceClassName);
    }
}
