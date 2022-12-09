package org.pcsoft.framework.jcoding.core.data.base;

import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceBuilder;

import java.util.function.Function;

@SuppressWarnings("unchecked")
public abstract class JAnnotatableBuilder<T extends JAnnotatableData, B extends JAnnotatableBuilder<T,B>> extends JNamedBuilder<T> {
    protected JAnnotatableBuilder(Class<T> dataClass, String name) {
        super(dataClass, name);
    }

    public B withAnnotation(Function<JAnnotationReferenceBuilder, JAnnotationReferenceBuilder> func) {
        final var builder = func.apply(new JAnnotationReferenceBuilder());
        data.getAnnotationReferences().add(builder.build());

        return (B) this;
    }
}
