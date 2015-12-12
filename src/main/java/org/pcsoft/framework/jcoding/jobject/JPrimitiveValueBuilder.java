package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JPrimitiveValueBuilder<V, T extends JPrimitiveValueDescriptor<V>, S extends JPrimitiveValueBuilder> extends JSimpleValueBuilder<V, T, S> {

    public JPrimitiveValueBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withUsePrimitive(final boolean flag) {
        value.setUsePrimitive(flag);
        return (S) this;
    }
}
