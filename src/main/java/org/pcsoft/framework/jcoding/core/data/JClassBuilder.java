package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JTypeBuilder;
import org.pcsoft.framework.jcoding.core.utils.TypeConverter;

import java.util.function.Function;

@Slf4j
public final class JClassBuilder extends JTypeBuilder<JClassData, JClassBuilder> {
    public JClassBuilder(String name) {
        super(JClassData.class, name);
    }

    public JClassBuilder isAbstract() {
        data.setAbstract(true);
        log.trace("Set abstract modifier for class " + data.getName());
        return this;
    }

    public JClassBuilder isFinal() {
        data.setFinal(true);
        log.trace("Set final modifier for class " + data.getName());
        return this;
    }

    public JClassBuilder useSuperType(Class<?> type) {
        log.trace("Set super type " + type.getCanonicalName() + " for class " + data.getName());
        data.setSuperType(TypeConverter.toTypeReference(type));

        return this;
    }

    public JClassBuilder useSuperType(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        final var builder = func.apply(new JTypeReferenceBuilder(name));
        log.trace("Set super type " + builder.build() + " for class " + data.getName());
        data.setSuperType(builder.build());

        return this;
    }
}
