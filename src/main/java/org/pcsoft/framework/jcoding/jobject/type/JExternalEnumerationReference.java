package org.pcsoft.framework.jcoding.jobject.type;

/**
 * Representation of external enumeration reference. To create see {@link JEnumerationReference}
 */
public final class JExternalEnumerationReference extends JExternalTypeReference implements JEnumerationReference {

    JExternalEnumerationReference(String fullReferenceClassName) {
        super(fullReferenceClassName);
    }
}
