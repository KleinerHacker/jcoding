package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Represent the java method builder base implementation.
 */
public abstract class JMethodBuilder<T extends JMethodDescriptor, S extends JMethodBuilder> extends JVisibilityDefinitionBuilder<T, S> {

    public JMethodBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withReturnType(final JReferenceBuilder typeReferenceBuilder) throws JCodingBuilderException {
        return withReturnType((JReferenceDescriptor) typeReferenceBuilder.build());
    }

    public S withReturnType(final JReferenceDescriptor typeReferenceDescriptor) {
        value.setReturnTypeDescriptor(typeReferenceDescriptor);
        return (S) this;
    }
}
