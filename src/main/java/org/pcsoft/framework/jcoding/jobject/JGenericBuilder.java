package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JGenericBuilder extends JObjectBuilderBase<JGenericDescriptor> {
    public static JGenericBuilder create() {
        return new JGenericBuilder();
    }

    public static JGenericBuilder create(final String name) {
        return create().withName(name);
    }

    public static JGenericBuilder create(final String name, final JTypeReferenceBuilder classExtension) throws JCodingBuilderException {
        return create(name).withClassExtension(classExtension);
    }

    private JGenericBuilder() {
        super(JGenericDescriptor.class);
    }

    public JGenericBuilder withName(final String name) {
        value.setName(name);
        return this;
    }

    public JGenericBuilder withClassExtension(final JTypeReferenceBuilder classExtension) throws JCodingBuilderException {
        return withClassExtension((JTypeReferenceDescriptor) classExtension.build());
    }

    public JGenericBuilder withClassExtension(final JTypeReferenceDescriptor classExtension) {
        value.setClassExtension(classExtension);
        return this;
    }

    public JGenericBuilder withInterfaceExtension(final JInterfaceReferenceBuilder interfaceExtension) throws JCodingBuilderException {
        return withInterfaceExtension(interfaceExtension.build());
    }

    public JGenericBuilder withInterfaceExtension(final JInterfaceReferenceDescriptor interfaceExtension) {
        value.addInterfaceExtension(interfaceExtension);
        return this;
    }

    public JGenericBuilder withInterfaceExtensions(final JInterfaceReferenceBuilder... interfaceExtensions) throws JCodingBuilderException {
        for (final JInterfaceReferenceBuilder interfaceExtension : interfaceExtensions) {
            value.addInterfaceExtension(interfaceExtension.build());
        }
        return this;
    }

    public JGenericBuilder withInterfaceExtensions(final JInterfaceReferenceDescriptor... interfaceExtensions) {
        for (final JInterfaceReferenceDescriptor interfaceExtension : interfaceExtensions) {
            value.addInterfaceExtension(interfaceExtension);
        }
        return this;
    }
}
