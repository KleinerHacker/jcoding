package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by Christoph on 12.12.2015.
 */
public abstract class JInheritableTypeBuilder<T extends JInheritableTypeDescriptor, S extends JInheritableTypeBuilder> extends JExtensibleTypeBuilder<T, S> {

    public JInheritableTypeBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withGeneric(final JGenericBuilder generic) throws JCodingBuilderException {
        return withGeneric(generic.build());
    }

    public S withGeneric(final JGenericDescriptor generic) {
        value.addGeneric(generic);
        return (S) this;
    }

    public S withGenerics(final JGenericBuilder... generics) throws JCodingBuilderException {
        for (final JGenericBuilder generic : generics) {
            value.addGeneric(generic.build());
        }
        return (S) this;
    }

    public S withGenerics(final JGenericDescriptor... generics) {
        for (final JGenericDescriptor generic : generics) {
            value.addGeneric(generic);
        }
        return (S) this;
    }
}
