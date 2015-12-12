package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JExternalAnnotationReferenceBuilder extends JExternalTypeReferenceBuilder<JExternalAnnotationReferenceDescriptor, JExternalAnnotationReferenceBuilder> implements JAnnotationReferenceBuilder<JExternalAnnotationReferenceDescriptor>{
    public static JExternalAnnotationReferenceBuilder create(String fullClassName) {
        return new JExternalAnnotationReferenceBuilder().withReferenceFullClassName(fullClassName);
    }

    public static JExternalAnnotationReferenceBuilder create(Class referenceClass) {
        return new JExternalAnnotationReferenceBuilder().withReferenceFullClassName(referenceClass);
    }

    private JExternalAnnotationReferenceBuilder() {
        super(JExternalAnnotationReferenceDescriptor.class);
    }
}
