package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent an annotation reference builder to create a {@link JInternalAnnotationReferenceDescriptor}
 */
public final class JInternalAnnotationReferenceBuilder extends JInternalTypeReferenceBuilder<JAnnotationDescriptor, JInternalAnnotationReferenceDescriptor, JInternalAnnotationReferenceBuilder> implements JAnnotationReferenceBuilder<JInternalAnnotationReferenceDescriptor> {
    public static JInternalAnnotationReferenceBuilder create() {
        return new JInternalAnnotationReferenceBuilder();
    }

    public static JInternalAnnotationReferenceBuilder create(JAnnotationDescriptor annotationDescriptor) {
        return create().withType(annotationDescriptor);
    }

    private JInternalAnnotationReferenceBuilder() {
        super(JInternalAnnotationReferenceDescriptor.class);
    }
}
