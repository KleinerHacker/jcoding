package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JStringValueBuilder extends JSimpleValueBuilder<String, JStringValueDescriptor, JStringValueBuilder> {
    public static JStringValueBuilder create() {
        return new JStringValueBuilder();
    }

    public static JStringValueBuilder create(final String value) {
        return create().withValue(value);
    }

    private JStringValueBuilder() {
        super(JStringValueDescriptor.class);
    }
}
