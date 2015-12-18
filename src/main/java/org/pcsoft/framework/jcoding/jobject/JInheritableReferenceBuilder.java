package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;
import org.pcsoft.framework.jcoding.jobject.type.JInheritableReference;

/**
 * Builder base to create {@link JInheritableReferenceDescriptor} based instances
 */
public abstract class JInheritableReferenceBuilder<R extends JInheritableReference, T extends JInheritableReferenceDescriptor<R>, S extends JInheritableReferenceBuilder> extends JTypeReferenceBuilder<R, T, S> {

    public JInheritableReferenceBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withGeneric(final JGenericValueBuilder generic) throws JCodingBuilderException {
        return withGeneric(generic.build());
    }

    public S withGeneric(final JGenericValueDescriptor generic) {
        value.addGeneric(generic);
        return (S) this;
    }

    public S withGenerics(final JGenericValueBuilder... generics) throws JCodingBuilderException {
        for (final JGenericValueBuilder generic : generics) {
            value.addGeneric(generic.build());
        }
        return (S) this;
    }

    public S withGenerics(final JGenericValueDescriptor... generics) {
        for (final JGenericValueDescriptor generic : generics) {
            value.addGeneric(generic);
        }
        return (S) this;
    }
}
