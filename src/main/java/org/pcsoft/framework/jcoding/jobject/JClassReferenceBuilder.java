package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public interface JClassReferenceBuilder<T extends JClassReferenceDescriptor> extends JObjectBuilder<T> {
    public static JExternalClassReferenceBuilder create(String fullClassName) {
        return JExternalClassReferenceBuilder.create(fullClassName);
    }

    public static JExternalClassReferenceBuilder create(Class referenceClass) {
        return JExternalClassReferenceBuilder.create(referenceClass);
    }

    public static JInternalClassReferenceBuilder create(JClassDescriptor classDescriptor) {
        return JInternalClassReferenceBuilder.create(classDescriptor);
    }
}
