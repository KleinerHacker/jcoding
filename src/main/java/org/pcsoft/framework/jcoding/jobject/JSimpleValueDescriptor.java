package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JSimpleValueDescriptor<T> extends JValueDescriptor {
    private T value;

    public JSimpleValueDescriptor() {
    }

    public T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }
}
