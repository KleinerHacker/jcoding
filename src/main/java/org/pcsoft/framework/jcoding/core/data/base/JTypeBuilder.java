package org.pcsoft.framework.jcoding.core.data.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

@Slf4j
@SuppressWarnings("unchecked")
public abstract class JTypeBuilder<T extends JTypeData, B extends JTypeBuilder<T,B>> extends JAnnotatableBuilder<T,B> {
    protected JTypeBuilder(Class<T> dataClass, String name) {
        super(dataClass, name);
    }

    public B isStatic() {
        data.setStatic(true);
        log.trace("Set static modifier for type " + data.getName());
        return (B) this;
    }

    public B hasAccess(JAccessModifier modifier) {
        data.setAccess(modifier);
        log.trace("Set access modifier to " + (modifier == null ? "null" : modifier.name()) + " for type " + data.getName());
        return (B) this;
    }
}
