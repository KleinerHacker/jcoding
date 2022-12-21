package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JMemberBuilder;
import org.pcsoft.framework.jcoding.core.utils.TypeConverter;

import java.util.function.Function;

@Slf4j
public final class JFieldBuilder extends JMemberBuilder<JFieldData, JFieldBuilder> {
    public JFieldBuilder(String name) {
        super(JFieldData.class, name);
    }

    public JFieldBuilder isFinal() {
        data.setFinal(true);
        log.debug("Set field " + data.getName() + " to final");
        return this;
    }

    public JFieldBuilder typeOf(Class<?> type) {
        data.setType(TypeConverter.toTypeReference(type));
        log.debug("Set field " + data.getName() + " to type " + data.getType());
        return this;
    }

    public JFieldBuilder typeOf(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        data.setType(func.apply(new JTypeReferenceBuilder(name)).build());
        log.debug("Set field " + data.getName() + " to type " + data.getType());
        return this;
    }

    public JFieldBuilder withValue(Object value) {
        data.setHasDirectInitialization(true);
        data.setValue(value);
        log.debug("Set value " + value + " direct to field " + data.getName());
        return this;
    }
}
