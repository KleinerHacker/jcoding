package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JInheritableTypeBuilder<T extends JInheritableTypeDescriptor, S extends JInheritableTypeBuilder> extends JTypeBuilder<JStandardMethodDescriptor, JStandardMethodBuilder, T, S> {

    public JInheritableTypeBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withInterface(final JInterfaceReferenceBuilder $interface) throws JCodingBuilderException {
        return withInterface($interface.build());
    }

    public S withInterface(final JInterfaceReferenceDescriptor $interface) {
        value.addInterface($interface);
        return (S) this;
    }

    public S withInterfaces(final JInterfaceReferenceBuilder... interfaces) throws JCodingBuilderException {
        for (final JInterfaceReferenceBuilder $interface : interfaces) {
            value.addInterface($interface.build());
        }
        return (S) this;
    }

    public S withInterfaces(final JInterfaceReferenceDescriptor... interfaces) {
        for (final JInterfaceReferenceDescriptor $interface : interfaces) {
            value.addInterface($interface);
        }
        return (S) this;
    }

    public S withoutInterface(final JInterfaceReferenceDescriptor $interface) {
        value.removeInterface($interface);
        return (S) this;
    }
}