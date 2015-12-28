package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JExtensibleTypeBuilder<T extends JExtensibleTypeDescriptor, S extends JExtensibleTypeBuilder> extends JTypeBuilder<JStandardMethodDescriptor, JStandardMethodBuilder, T, S> {

    public JExtensibleTypeBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withInterface(final JInterfaceReferenceBuilder $interface) throws JCodingBuilderException {
        return withInterface((JInterfaceReferenceDescriptor) $interface.build());
    }

    public S withInterface(final JInterfaceReferenceDescriptor $interface) {
        value.addInterface($interface);
        return (S) this;
    }

    public S withInterfaces(final JInterfaceReferenceBuilder... interfaces) throws JCodingBuilderException {
        for (final JInterfaceReferenceBuilder $interface : interfaces) {
            value.addInterface((JInterfaceReferenceDescriptor) $interface.build());
        }
        return (S) this;
    }

    public S withInterfaces(final JInterfaceReferenceDescriptor... interfaces) {
        for (final JInterfaceReferenceDescriptor $interface : interfaces) {
            value.addInterface($interface);
        }
        return (S) this;
    }

    public S withField(final JFieldDescriptor field) {
        value.addField(field);
        return (S) this;
    }

    public S withField(final JFieldBuilder field) throws JCodingBuilderException {
        return withField(field.build());
    }

    public S withFields(final JFieldDescriptor... fields) {
        for (final JFieldDescriptor field : fields) {
            value.addField(field);
        }
        return (S) this;
    }

    public S withFields(final JFieldBuilder... fields) throws JCodingBuilderException {
        for (final JFieldBuilder field : fields) {
            value.addField(field.build());
        }
        return (S) this;
    }
}
