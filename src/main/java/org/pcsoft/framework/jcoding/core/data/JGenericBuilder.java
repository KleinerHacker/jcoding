package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JNamedBuilder;
import org.pcsoft.framework.jcoding.core.utils.TypeConverter;

import java.util.function.Function;

@Slf4j
public final class JGenericBuilder extends JNamedBuilder<JGenericData> {
    public JGenericBuilder(String name) {
        super(JGenericData.class, name);
    }

    public JGenericBuilder extendsFrom(Class<?> type) {
        log.trace("set extends from " + type.getCanonicalName() + " of generic " + data.getName());
        data.setExtendsType(TypeConverter.toTypeReference(type));

        return this;
    }

    public JGenericBuilder extendsFrom(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        final var builder = func.apply(new JTypeReferenceBuilder(name));
        log.trace("set extends from " + builder.build() + " of generic " + data.getName());
        data.setExtendsType(builder.build());

        return this;
    }

    public JGenericBuilder superFrom(Class<?> type) {
        log.trace("set super from " + type.getCanonicalName() + " of generic " + data.getName());
        data.setSuperType(TypeConverter.toTypeReference(type));

        return this;
    }

    public JGenericBuilder superFrom(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        final var builder = func.apply(new JTypeReferenceBuilder(name));
        log.trace("set super from " + builder.build() + " of generic " + data.getName());
        data.setSuperType(builder.build());

        return this;
    }
}
