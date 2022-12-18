package org.pcsoft.framework.jcoding.core.data.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

@Slf4j
@SuppressWarnings("unchecked")
public abstract class JMemberBuilder<T extends JMemberData, B extends JMemberBuilder<T, B>> extends JAnnotatableBuilder<T, B> {
    protected JMemberBuilder(Class<T> dataClass, String name) {
        super(dataClass, name);
    }

    public B hasAccess(JAccessModifier modifier) {
        data.setAccess(modifier);
        log.trace("Set access modifier to " + (modifier == null ? "null" : modifier.name()) + " for member " + data.getName());
        return (B) this;
    }

    public B isStatic() {
        data.setStatic(true);
        log.trace("Set static modifier for class " + data.getName());
        return (B) this;
    }
}

