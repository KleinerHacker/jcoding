package org.pcsoft.framework.jcoding.jobject.type;

/**
 * Representation of external class reference. To create see {@link JClassReference}
 */
public final class JExternalClassReference extends JExternalTypeReference implements JClassReference {

    JExternalClassReference(String fullReferenceClassName) {
        super(fullReferenceClassName);
    }
}
