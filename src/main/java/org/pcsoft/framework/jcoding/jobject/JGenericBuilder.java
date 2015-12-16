package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JGenericBuilder extends JObjectBuilderBase<JGenericDescriptor> {
    public static JGenericBuilder create(final String name) {
        return new JGenericBuilder().withName(name);
    }

    public static JGenericBuilder create(final String name, final JTypeReferenceBuilderBase classExtension) throws JCodingBuilderException {
        return create(name).withClassExtension(classExtension);
    }

    private JGenericBuilder() {
        super(JGenericDescriptor.class);
    }

    public JGenericBuilder withName(final String name) {
        value.setName(name);
        return this;
    }

    public JGenericBuilder withClassExtension(final JTypeReferenceBuilderBase classExtension) throws JCodingBuilderException {
        return withClassExtension((JTypeReferenceDescriptorBase) classExtension.build());
    }

    public JGenericBuilder withClassExtension(final JTypeReferenceDescriptorBase classExtension) {
        value.setClassExtension(classExtension);
        return this;
    }

    public JGenericBuilder withInterfaceExtension(final JInternalInterfaceReferenceBuilder interfaceExtension) throws JCodingBuilderException {
        return withInterfaceExtension(interfaceExtension.build());
    }

    public JGenericBuilder withInterfaceExtension(final JInternalInterfaceReferenceDescriptor interfaceExtension) {
        value.addInterfaceExtension(interfaceExtension);
        return this;
    }

    public JGenericBuilder withInterfaceExtensions(final JInternalInterfaceReferenceBuilder... interfaceExtensions) throws JCodingBuilderException {
        for (final JInternalInterfaceReferenceBuilder interfaceExtension : interfaceExtensions) {
            value.addInterfaceExtension(interfaceExtension.build());
        }
        return this;
    }

    public JGenericBuilder withInterfaceExtensions(final JInternalInterfaceReferenceDescriptor... interfaceExtensions) {
        for (final JInternalInterfaceReferenceDescriptor interfaceExtension : interfaceExtensions) {
            value.addInterfaceExtension(interfaceExtension);
        }
        return this;
    }

    public JGenericBuilder withoutInterfaceExtension(final JInternalInterfaceReferenceDescriptor interfaceExtension) {
        value.removeInterfaceExtension(interfaceExtension);
        return this;
    }
}
