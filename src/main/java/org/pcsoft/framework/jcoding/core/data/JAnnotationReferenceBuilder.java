package org.pcsoft.framework.jcoding.core.data;

import org.pcsoft.framework.jcoding.core.data.base.JBuilder;

import java.util.function.Function;

public final class JAnnotationReferenceBuilder extends JBuilder<JAnnotationReferenceData> {
    public JAnnotationReferenceBuilder() {
        super(JAnnotationReferenceData.class);
    }

    public JAnnotationReferenceBuilder ofType(Class<?> type) {
        data.setType(
                new JTypeReferenceBuilder(type.getSimpleName())
                        .inPackage(type.getPackageName())
                        .build()
        );

        return this;
    }

    public JAnnotationReferenceBuilder ofType(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        var builder = func.apply(new JTypeReferenceBuilder(name));
        data.setType(builder.build());

        return this;
    }

    public JAnnotationReferenceBuilder withParameter(String name, Function<JParameterReferenceBuilder, JParameterReferenceBuilder> func) {
        final var builder = func.apply(new JParameterReferenceBuilder(name));
        data.getParameterReferences().add(builder.build());

        return this;
    }
}
