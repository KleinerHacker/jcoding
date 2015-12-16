package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 16.12.2015.
 */
public final class JGenericValueBuilder extends JObjectBuilderBase<JGenericValueDescriptor> {
    public static JGenericValueBuilder create() {
        return new JGenericValueBuilder();
    }

    public static JGenericValueBuilder create(final JTypeReferenceDescriptor typeReference) {
        return create().withTypeReference(typeReference);
    }

    private JGenericValueBuilder() {
        super(JGenericValueDescriptor.class);
    }

    public JGenericValueBuilder withTypeReference(final JTypeReferenceDescriptor typeReference) {
        value.setTypeReference(typeReference);
        return this;
    }

    public JGenericValueBuilder withWildcard(final boolean flag) {
        value.setWildcard(flag);
        return this;
    }
}
