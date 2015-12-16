package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent an enumeration reference builder to create a {@link JInternalEnumerationReferenceDescriptor}
 */
public final class JInternalEnumerationReferenceBuilder extends JInternalTypeReferenceBuilder<JEnumerationDescriptor, JInternalEnumerationReferenceDescriptor, JInternalEnumerationReferenceBuilder> implements JEnumerationReferenceBuilder<JInternalEnumerationReferenceDescriptor> {
    public static JInternalEnumerationReferenceBuilder create() {
        return new JInternalEnumerationReferenceBuilder();
    }

    public static JInternalEnumerationReferenceBuilder create(JEnumerationDescriptor enumerationDescriptor) {
        return create().withType(enumerationDescriptor);
    }

    private JInternalEnumerationReferenceBuilder() {
        super(JInternalEnumerationReferenceDescriptor.class);
    }
}
