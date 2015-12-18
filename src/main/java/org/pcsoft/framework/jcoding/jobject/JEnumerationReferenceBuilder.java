package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.jobject.type.JEnumerationReference;

/**
 * Builder to create {@link JEnumerationReferenceDescriptor}, based on {@link JEnumerationReference}
 */
public final class JEnumerationReferenceBuilder extends JTypeReferenceBuilder<JEnumerationReference, JEnumerationReferenceDescriptor, JEnumerationReferenceBuilder> {
    public static JEnumerationReferenceBuilder create() {
        return new JEnumerationReferenceBuilder();
    }

    public static JEnumerationReferenceBuilder create(final JEnumerationReference enumerationReference) {
        return create().withTypeReference(enumerationReference);
    }

    private JEnumerationReferenceBuilder() {
        super(JEnumerationReferenceDescriptor.class);
    }
}
