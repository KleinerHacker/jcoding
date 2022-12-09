package org.pcsoft.framework.jcoding.core.data.base;

import java.lang.reflect.InvocationTargetException;

public abstract class JBuilder<T extends JData> {
    protected final T data;

    protected JBuilder(Class<T> dataClass) {
        try {
            data = dataClass.getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    public final T build() {
        return data;
    }
}
