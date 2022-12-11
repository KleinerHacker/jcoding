package org.pcsoft.framework.jcoding.core.data.base;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class JNamedBuilder<T extends JNamedData> extends JBuilder<T> {
    protected JNamedBuilder(Class<T> dataClass, String name) {
        super(dataClass);
        log.trace("Create object with name " + name);
        data.setName(name);
    }
}
