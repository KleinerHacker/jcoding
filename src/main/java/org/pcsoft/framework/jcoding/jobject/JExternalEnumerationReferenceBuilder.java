package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JExternalEnumerationReferenceBuilder extends JExternalTypeReferenceBuilder<JExternalEnumerationReferenceDescriptor, JExternalEnumerationReferenceBuilder> implements JEnumerationReferenceBuilder<JExternalEnumerationReferenceDescriptor>{
    public static JExternalEnumerationReferenceBuilder create() {
        return new JExternalEnumerationReferenceBuilder();
    }

    public static JExternalEnumerationReferenceBuilder create(String fullClassName) {
        return create().withReferenceFullClassName(fullClassName);
    }

    public static JExternalEnumerationReferenceBuilder create(Class referenceClass) {
        return create().withReferenceFullClassName(referenceClass);
    }

    private JExternalEnumerationReferenceBuilder() {
        super(JExternalEnumerationReferenceDescriptor.class);
    }
}
