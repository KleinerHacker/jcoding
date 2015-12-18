package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JInterfaceDescriptor;

/**
 * Marker interface for interface reference
 */
public interface JInterfaceReference extends JInheritableReference {

    public static JInterfaceReference create(final JInterfaceDescriptor interfaceDescriptor) {
        return new JInternalInterfaceReference(interfaceDescriptor);
    }

    public static JInterfaceReference create(final String fullClassName) {
        return new JExternalInterfaceReference(fullClassName);
    }

    public static JInterfaceReference create(final Class<?> annotationClass) {
        return create(annotationClass.getName());
    }

}
