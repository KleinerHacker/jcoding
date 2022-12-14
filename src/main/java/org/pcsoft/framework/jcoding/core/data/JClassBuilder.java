package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JTypeBuilder;

@Slf4j
public final class JClassBuilder extends JTypeBuilder<JClassData, JClassBuilder> {
    public JClassBuilder(String name) {
        super(JClassData.class, name);
    }

    public JClassBuilder isStatic() {
        data.setStatic(true);
        log.trace("Set static modifier for class " + data.getName());
        return this;
    }

    public JClassBuilder isAbstract() {
        data.setAbstract(true);
        log.trace("Set abstract modifier for type " + data.getName());
        return this;
    }

    public JClassBuilder isFinal() {
        data.setFinal(true);
        log.trace("Set final modifier for type " + data.getName());
        return this;
    }
}
