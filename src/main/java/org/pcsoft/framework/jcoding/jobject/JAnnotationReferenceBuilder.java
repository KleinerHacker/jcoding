package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.jobject.type.JAnnotationReference;

/**
 * Builder to create a {@link JAnnotationDescriptor}, based on a {@link JAnnotationReference}.
 */
public final class JAnnotationReferenceBuilder extends JTypeReferenceBuilder<JAnnotationReference, JAnnotationReferenceDescriptor, JAnnotationReferenceBuilder> {
    public static JAnnotationReferenceBuilder create() {
        return new JAnnotationReferenceBuilder();
    }

    public static JAnnotationReferenceBuilder create(final JAnnotationReference annotationReference) {
        return create().withTypeReference(annotationReference);
    }

    private JAnnotationReferenceBuilder() {
        super(JAnnotationReferenceDescriptor.class);
    }
}
