package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 16.12.2015.
 */
public final class JGenericReferenceBuilder extends JReferenceBuilderBase<JGenericReferenceDescriptor, JGenericReferenceBuilder> {
    public static JGenericReferenceBuilder create() {
        return new JGenericReferenceBuilder();
    }

    public static JGenericReferenceBuilder create(final JGenericDescriptor genericReference) {
        return create().withGenericReference(genericReference);
    }

    private JGenericReferenceBuilder() {
        super(JGenericReferenceDescriptor.class);
    }

    public JGenericReferenceBuilder withGenericReference(final JGenericDescriptor genericReference) {
        value.setGenericReference(genericReference);
        return this;
    }
}
