package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent an enumeration reference builder to create a {@link JEnumerationReferenceDescriptor}
 */
public final class JEnumerationReferenceBuilder extends JTypeReferenceBuilder<JEnumerationDescriptor, JEnumerationReferenceDescriptor, JEnumerationReferenceBuilder> {
    public static JEnumerationReferenceBuilder create(JEnumerationDescriptor enumerationDescriptor) {
        return new JEnumerationReferenceBuilder().withType(enumerationDescriptor);
    }

    private JEnumerationReferenceBuilder() {
        super(JEnumerationReferenceDescriptor.class);
    }
}
