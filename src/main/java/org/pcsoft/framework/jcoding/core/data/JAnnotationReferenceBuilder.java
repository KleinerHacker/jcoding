package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JBuilder;
import org.pcsoft.framework.jcoding.core.utils.TypeConverter;

import java.util.function.Function;

@Slf4j
public final class JAnnotationReferenceBuilder extends JBuilder<JAnnotationReferenceData> {
    public JAnnotationReferenceBuilder() {
        super(JAnnotationReferenceData.class);
    }

    public JAnnotationReferenceBuilder ofType(Class<?> type) {
        data.setType(TypeConverter.toTypeReference(type));
        log.trace("Set annotation reference type to " + type.getCanonicalName());

        return this;
    }

    public JAnnotationReferenceBuilder ofType(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        var builder = func.apply(new JTypeReferenceBuilder(name));
        log.trace("Set annotation reference type to " + builder.build());
        data.setType(builder.build());

        return this;
    }

    public JAnnotationReferenceBuilder withParameter(String name, Function<JParameterReferenceBuilder, JParameterReferenceBuilder> func) {
        final var builder = func.apply(new JParameterReferenceBuilder(name));
        log.trace("Add parameter reference to annotation type " + data.getType());
        data.getParameterReferences().add(builder.build());

        return this;
    }
}
