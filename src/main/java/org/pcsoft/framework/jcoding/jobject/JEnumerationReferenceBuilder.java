package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public interface JEnumerationReferenceBuilder<T extends JEnumerationReferenceDescriptor> extends JObjectBuilder<T> {
    public static JExternalEnumerationReferenceBuilder create(String fullClassName) {
        return JExternalEnumerationReferenceBuilder.create(fullClassName);
    }

    public static JExternalEnumerationReferenceBuilder create(Class referenceClass) {
        return JExternalEnumerationReferenceBuilder.create(referenceClass);
    }

    public static JInternalEnumerationReferenceBuilder create(JEnumerationDescriptor enumerationDescriptor) {
        return JInternalEnumerationReferenceBuilder.create(enumerationDescriptor);
    }
}
