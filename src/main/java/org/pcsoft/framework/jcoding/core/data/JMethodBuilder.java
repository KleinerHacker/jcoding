package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JMemberBuilder;
import org.pcsoft.framework.jcoding.core.utils.TypeConverter;

import java.util.function.Function;

@Slf4j
public final class JMethodBuilder extends JMemberBuilder<JMethodData, JMethodBuilder> {
    public JMethodBuilder(String name) {
        super(JMethodData.class, name);
    }

    public JMethodBuilder isFinal() {
        data.setFinal(true);
        log.trace("Set method " + data.getName() + " to final");
        return this;
    }

    public JMethodBuilder isAbstract() {
        data.setAbstract(true);
        log.trace("Set method " + data.getName() + " to abstract");
        return this;
    }

    public JMethodBuilder withReturnType(Class<?> type) {
        data.setReturnType(TypeConverter.toTypeReference(type));
        log.trace("Set return value of method " + data.getName() + " to " + data.getReturnType());
        return this;
    }

    public JMethodBuilder withReturnType(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        data.setReturnType(func.apply(new JTypeReferenceBuilder(name)).build());
        log.trace("Set return value of method " + data.getName() + " to " + data.getReturnType());
        return this;
    }

    public JMethodBuilder withParameter(String name, Function<JParameterBuilder, JParameterBuilder> func) {
        final var parameterData = func.apply(new JParameterBuilder(name)).build();
        data.getParameters().add(parameterData);
        log.trace("Add parameter " + parameterData + " to method " + data.getName());
        return this;
    }
}
