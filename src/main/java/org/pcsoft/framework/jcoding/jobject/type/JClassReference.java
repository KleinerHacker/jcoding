package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JClassDescriptor;

/**
 * Marker interface for class reference
 */
public interface JClassReference extends JInheritableReference {

    public static JClassReference create(final JClassDescriptor classDescriptor) {
        return new JInternalClassReference(classDescriptor);
    }

    public static JClassReference create(final String fullClassName) {
        return new JExternalClassReference(fullClassName);
    }

    public static JClassReference create(final Class<?> classClass) {
        return create(classClass.getName());
    }

}
