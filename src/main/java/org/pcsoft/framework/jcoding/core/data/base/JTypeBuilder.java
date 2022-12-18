package org.pcsoft.framework.jcoding.core.data.base;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class JTypeBuilder<T extends JTypeData, B extends JTypeBuilder<T,B>> extends JMemberBuilder<T,B> {
    protected JTypeBuilder(Class<T> dataClass, String name) {
        super(dataClass, name);
    }
}
