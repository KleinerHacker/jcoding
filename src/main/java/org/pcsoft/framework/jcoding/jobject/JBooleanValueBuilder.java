package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JBooleanValueBuilder extends JPrimitiveValueBuilder<Boolean, JBooleanValueDescriptor, JBooleanValueBuilder> {
    public static JBooleanValueBuilder create() {
        return new JBooleanValueBuilder();
    }

    public static JBooleanValueBuilder create(final Boolean value) {
        return create().withValue(value);
    }

    private JBooleanValueBuilder() {
        super(JBooleanValueDescriptor.class);
    }
}
