package org.pcsoft.framework.jcoding.core.data.base;

public abstract class JNamedBuilder<T extends JNamedData> extends JBuilder<T> {
    protected JNamedBuilder(Class<T> dataClass, String name) {
        super(dataClass);
        data.setName(name);
    }
}
