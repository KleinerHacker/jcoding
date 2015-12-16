package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JParameterBuilder extends JDefinitionBuilder<JParameterDescriptor, JParameterBuilder> {
    public static JParameterBuilder create() {
        return new JParameterBuilder();
    }

    public static JParameterBuilder create(final String name, final JTypeReferenceBuilderBase type) throws JCodingBuilderException {
        return create().withName(name).withType(type);
    }

    public static JParameterBuilder create(final String name, final JTypeReferenceDescriptorBase type) {
        return create().withName(name).withType(type);
    }

    private JParameterBuilder() {
        super(JParameterDescriptor.class);
    }

    public JParameterBuilder withFinal(final boolean flag) {
        value.setFinal(flag);
        return this;
    }

    public JParameterBuilder withType(final JTypeReferenceBuilderBase typeReferenceBuilder) throws JCodingBuilderException {
        return withType((JTypeReferenceDescriptorBase) typeReferenceBuilder.build());
    }

    public JParameterBuilder withType(final JTypeReferenceDescriptorBase typeReferenceDescriptor) {
        value.setType(typeReferenceDescriptor);
        return this;
    }
}
