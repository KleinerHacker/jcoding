package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JEnumerationBuilder extends JExtensibleTypeBuilder<JEnumerationDescriptor, JEnumerationBuilder> {
    public static JEnumerationBuilder create(final JVisibility visibility, final String name) {
        return new JEnumerationBuilder().withVisibility(visibility).withName(name);
    }

    public static JEnumerationBuilder create(final String name) {
        return create(JVisibility.Public, name);
    }

    private JEnumerationBuilder() {
        super(JEnumerationDescriptor.class);
    }
}
