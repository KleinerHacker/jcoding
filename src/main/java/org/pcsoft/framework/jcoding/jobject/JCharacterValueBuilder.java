package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JCharacterValueBuilder extends JPrimitiveValueBuilder<Character, JCharacterValueDescriptor, JCharacterValueBuilder> {
    public static JCharacterValueBuilder create() {
        return new JCharacterValueBuilder();
    }

    public static JCharacterValueBuilder create(Character value) {
        return create().withValue(value);
    }

    private JCharacterValueBuilder() {
        super(JCharacterValueDescriptor.class);
    }
}
