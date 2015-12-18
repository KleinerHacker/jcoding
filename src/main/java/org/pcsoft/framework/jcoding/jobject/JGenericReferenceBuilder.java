package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by Christoph on 16.12.2015.
 */
public final class JGenericReferenceBuilder extends JReferenceBuilder<JGenericReferenceDescriptor, JGenericReferenceBuilder> {
    public static JGenericReferenceBuilder create() {
        return new JGenericReferenceBuilder();
    }

    public static JGenericReferenceBuilder create(final JGenericDescriptor genericReference) {
        return create().withGenericReference(genericReference);
    }

    public static JGenericReferenceBuilder create(final JGenericBuilder genericReference) throws JCodingBuilderException {
        return create().withGenericReference(genericReference);
    }

    private JGenericReferenceBuilder() {
        super(JGenericReferenceDescriptor.class);
    }

    public JGenericReferenceBuilder withGenericReference(final JGenericBuilder genericReference) throws JCodingBuilderException {
        return withGenericReference(genericReference.build());
    }

    public JGenericReferenceBuilder withGenericReference(final JGenericDescriptor genericReference) {
        value.setGenericReference(genericReference);
        return this;
    }
}
