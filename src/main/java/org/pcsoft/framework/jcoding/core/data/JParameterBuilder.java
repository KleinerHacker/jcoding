package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JAnnotatableBuilder;
import org.pcsoft.framework.jcoding.core.utils.TypeConverter;

import java.util.function.Function;

@Slf4j
public final class JParameterBuilder extends JAnnotatableBuilder<JParameterData, JParameterBuilder> {
    public JParameterBuilder(String name) {
        super(JParameterData.class, name);
    }

    public JParameterBuilder isFinal() {
        data.setFinal(true);
        return this;
    }

    public JParameterBuilder ofType(Class<?> type) {
        data.setType(TypeConverter.toTypeReference(type));
        log.trace("Set type of parameter " + data.getName() + " to " + data.getType());
        return this;
    }

    public JParameterBuilder ofType(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        data.setType(func.apply(new JTypeReferenceBuilder(name)).build());
        log.trace("Set type of parameter " + data.getName() + " to " + data.getType());
        return this;
    }
}
