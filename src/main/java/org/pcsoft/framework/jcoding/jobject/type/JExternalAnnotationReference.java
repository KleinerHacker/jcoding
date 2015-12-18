package org.pcsoft.framework.jcoding.jobject.type;

/**
 * Representation of external annotation reference. To create see {@link JAnnotationReference}
 */
public final class JExternalAnnotationReference extends JExternalTypeReference implements JAnnotationReference {

    JExternalAnnotationReference(String fullReferenceClassName) {
        super(fullReferenceClassName);
    }
}
