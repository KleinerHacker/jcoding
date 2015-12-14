package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public interface JAnnotationReferenceBuilder<T extends JAnnotationReferenceDescriptor> extends JObjectBuilder<T> {
    public static JExternalAnnotationReferenceBuilder create(String fullClassName) {
        return JExternalAnnotationReferenceBuilder.create(fullClassName);
    }

    public static JExternalAnnotationReferenceBuilder create(Class referenceClass) {
        return JExternalAnnotationReferenceBuilder.create(referenceClass);
    }

    public static JInternalAnnotationReferenceBuilder create(JAnnotationDescriptor annotationDescriptor) {
        return JInternalAnnotationReferenceBuilder.create(annotationDescriptor);
    }
}
