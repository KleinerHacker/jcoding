package org.pcsoft.framework.jcoding.core.data.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceBuilder;

import java.util.function.Function;

@Slf4j
@SuppressWarnings("unchecked")
public abstract class JAnnotatableBuilder<T extends JAnnotatableData, B extends JAnnotatableBuilder<T,B>> extends JNamedBuilder<T> {
    protected JAnnotatableBuilder(Class<T> dataClass, String name) {
        super(dataClass, name);
    }

    public B withAnnotation(Function<JAnnotationReferenceBuilder, JAnnotationReferenceBuilder> func) {
        final var builder = func.apply(new JAnnotationReferenceBuilder());
        log.trace("Add annotation reference to annotable object '" + data.getName() + "': " + builder.build());
        data.getAnnotationReferences().add(builder.build());

        return (B) this;
    }
}
