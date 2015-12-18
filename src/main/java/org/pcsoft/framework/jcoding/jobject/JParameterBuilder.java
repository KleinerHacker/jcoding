package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JParameterBuilder extends JDefinitionBuilder<JParameterDescriptor, JParameterBuilder> {
    public static JParameterBuilder create() {
        return new JParameterBuilder();
    }

    public static JParameterBuilder create(final String name, final JReferenceBuilder type) throws JCodingBuilderException {
        return create().withName(name).withType(type);
    }

    public static JParameterBuilder create(final String name, final JReferenceDescriptor type) {
        return create().withName(name).withType(type);
    }

    private JParameterBuilder() {
        super(JParameterDescriptor.class);
    }

    public JParameterBuilder withFinal(final boolean flag) {
        value.setFinal(flag);
        return this;
    }

    public JParameterBuilder withType(final JReferenceBuilder referenceBuilder) throws JCodingBuilderException {
        return withType((JReferenceDescriptor) referenceBuilder.build());
    }

    public JParameterBuilder withType(final JReferenceDescriptor referenceDescriptor) {
        value.setReference(referenceDescriptor);
        return this;
    }
}
