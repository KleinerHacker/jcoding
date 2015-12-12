package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JBooleanValueBuilder extends JPrimitiveValueBuilder<Boolean, JBooleanValueDescriptor, JBooleanValueBuilder> {
    public static JBooleanValueBuilder create(final Boolean value) {
        return new JBooleanValueBuilder().withValue(value);
    }

    private JBooleanValueBuilder() {
        super(JBooleanValueDescriptor.class);
    }
}
