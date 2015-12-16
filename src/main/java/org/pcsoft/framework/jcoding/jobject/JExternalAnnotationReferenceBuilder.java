package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JExternalAnnotationReferenceBuilder extends JExternalTypeReferenceBuilder<JExternalAnnotationReferenceDescriptor, JExternalAnnotationReferenceBuilder> implements JAnnotationReferenceBuilder<JExternalAnnotationReferenceDescriptor>{
    public static JExternalAnnotationReferenceBuilder create() {
        return new JExternalAnnotationReferenceBuilder();
    }

    public static JExternalAnnotationReferenceBuilder create(String fullClassName) {
        return create().withReferenceFullClassName(fullClassName);
    }

    public static JExternalAnnotationReferenceBuilder create(Class referenceClass) {
        return create().withReferenceFullClassName(referenceClass);
    }

    private JExternalAnnotationReferenceBuilder() {
        super(JExternalAnnotationReferenceDescriptor.class);
    }
}
