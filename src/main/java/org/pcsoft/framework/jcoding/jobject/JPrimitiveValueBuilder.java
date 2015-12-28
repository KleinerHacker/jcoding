package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JNumberType;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JPrimitiveValueBuilder<V, T extends JPrimitiveValueDescriptor<V>, S extends JPrimitiveValueBuilder> extends JSimpleValueBuilder<V, T, S> {
    public static JPrimitiveValueBuilder create(final Number value, final JNumberType numberType) {
        return JNumberValueBuilder.create(value, numberType);
    }

    public static JPrimitiveValueBuilder create(final Boolean value) {
        return JBooleanValueBuilder.create(value);
    }

    public static JPrimitiveValueBuilder create(final Character value) {
        return JCharacterValueBuilder.create(value);
    }

    public JPrimitiveValueBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withUsePrimitive(final boolean flag) {
        value.setUsePrimitive(flag);
        return (S) this;
    }
}
