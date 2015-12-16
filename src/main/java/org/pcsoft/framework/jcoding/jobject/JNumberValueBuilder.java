package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JNumberType;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JNumberValueBuilder extends JPrimitiveValueBuilder<Number, JNumberValueDescriptor, JNumberValueBuilder> {
    public static JNumberValueBuilder create() {
        return new JNumberValueBuilder();
    }

    public static JNumberValueBuilder create(Number value, JNumberType numberType) {
        return create().withValue(value).withNumberType(numberType);
    }

    private JNumberValueBuilder() {
        super(JNumberValueDescriptor.class);
    }

    public JNumberValueBuilder withNumberType(final JNumberType numberType) {
        value.setNumber(numberType);
        return this;
    }
}
