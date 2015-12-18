package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Builder to create a {@link JGenericValueDescriptor}.
 */
public final class JGenericValueBuilder extends JObjectBuilderBase<JGenericValueDescriptor> {
    public static JGenericValueBuilder create() {
        return new JGenericValueBuilder();
    }

    public static JGenericValueBuilder create(final JReferenceDescriptor reference) {
        return create().withReference(reference);
    }

    public static JGenericValueBuilder create(final JReferenceBuilder reference) throws JCodingBuilderException {
        return create().withReference(reference);
    }

    private JGenericValueBuilder() {
        super(JGenericValueDescriptor.class);
    }

    public JGenericValueBuilder withReference(final JReferenceBuilder reference) throws JCodingBuilderException {
        return withReference((JReferenceDescriptor) reference.build());
    }

    public JGenericValueBuilder withReference(final JReferenceDescriptor reference) {
        value.setReference(reference);
        return this;
    }

    public JGenericValueBuilder withWildcard(final boolean flag) {
        value.setWildcard(flag);
        return this;
    }
}
