package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JNumberType;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JSimpleValueBuilder<V, T extends JSimpleValueDescriptor<V>, S extends JSimpleValueBuilder> extends JValueBuilder<T, S> {
    public static JValueBuilder create(final String value) {
        return JStringValueBuilder.create(value);
    }

    public static JValueBuilder create(final Number value, final JNumberType numberType) {
        return JNumberValueBuilder.create(value, numberType);
    }

    public static JValueBuilder create(final Boolean value) {
        return JBooleanValueBuilder.create(value);
    }

    public static JValueBuilder create(final Character value) {
        return JCharacterValueBuilder.create(value);
    }

    public JSimpleValueBuilder(final Class<T> clazz) {
        super(clazz);
    }

    public S withValue(final V value) {
        this.value.setValue(value);
        return (S) this;
    }
}
