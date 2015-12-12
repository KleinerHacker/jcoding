package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent an annotation reference builder to create a {@link JAnnotationReferenceDescriptor}
 */
public final class JAnnotationReferenceBuilder extends JTypeReferenceBuilder<JAnnotationDescriptor, JAnnotationReferenceDescriptor, JAnnotationReferenceBuilder> {
    public static JAnnotationReferenceBuilder create(JAnnotationDescriptor annotationDescriptor) {
        return new JAnnotationReferenceBuilder().withType(annotationDescriptor);
    }

    private JAnnotationReferenceBuilder() {
        super(JAnnotationReferenceDescriptor.class);
    }
}
