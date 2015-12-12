package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Represent the java method builder base implementation.
 */
public abstract class JMethodBuilder<T extends JMethodDescriptor, S extends JMethodBuilder> extends JVisibilityDefinitionBuilder<T, S> {

    public JMethodBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withReturnType(final JTypeReferenceBuilder typeReferenceBuilder) throws JCodingBuilderException {
        return withReturnType((JTypeReferenceDescriptor) typeReferenceBuilder.build());
    }

    public S withReturnType(final JTypeReferenceDescriptor typeReferenceDescriptor) {
        value.setReturnTypeDescriptor(typeReferenceDescriptor);
        return (S) this;
    }
}
