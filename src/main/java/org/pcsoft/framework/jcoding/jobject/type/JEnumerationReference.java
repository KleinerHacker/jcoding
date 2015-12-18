package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JEnumerationDescriptor;

/**
 * Marker interface for a enumeration reference
 */
public interface JEnumerationReference extends JTypeReference {

    public static JEnumerationReference create(final JEnumerationDescriptor enumerationDescriptor) {
        return new JInternalEnumerationReference(enumerationDescriptor);
    }

    public static JEnumerationReference create(final String fullClassName) {
        return new JExternalEnumerationReference(fullClassName);
    }

    public static JEnumerationReference create(final Class<?> enumerationClass) {
        return create(enumerationClass.getName());
    }

}
