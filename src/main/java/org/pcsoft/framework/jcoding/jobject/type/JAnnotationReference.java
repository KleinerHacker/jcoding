package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JAnnotationDescriptor;

/**
 * Marker interface for an annotation reference
 */
public interface JAnnotationReference extends JTypeReference {

    public static JAnnotationReference create(final JAnnotationDescriptor annotationDescriptor) {
        return new JInternalAnnotationReference(annotationDescriptor);
    }

    public static JAnnotationReference create(final String fullClassName) {
        return new JExternalAnnotationReference(fullClassName);
    }

    public static JAnnotationReference create(final Class<?> annotationClass) {
        return create(annotationClass.getName());
    }

}
