package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JExternalEnumerationReferenceBuilder extends JExternalTypeReferenceBuilder<JExternalEnumerationReferenceDescriptor, JExternalEnumerationReferenceBuilder> implements JEnumerationReferenceBuilder<JExternalEnumerationReferenceDescriptor>{
    public static JExternalEnumerationReferenceBuilder create(String fullClassName) {
        return new JExternalEnumerationReferenceBuilder().withReferenceFullClassName(fullClassName);
    }

    public static JExternalEnumerationReferenceBuilder create(Class referenceClass) {
        return new JExternalEnumerationReferenceBuilder().withReferenceFullClassName(referenceClass);
    }

    private JExternalEnumerationReferenceBuilder() {
        super(JExternalEnumerationReferenceDescriptor.class);
    }
}
