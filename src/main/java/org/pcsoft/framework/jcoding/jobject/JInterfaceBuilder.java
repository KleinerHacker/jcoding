package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JInterfaceBuilder extends JInheritableTypeBuilder<JInterfaceDescriptor, JInterfaceBuilder> {
    public static JInterfaceBuilder create(final JVisibility visibility, final String name) {
        return new JInterfaceBuilder().withVisibility(visibility).withName(name);
    }

    public static JInterfaceBuilder create(final String name) {
        return create(JVisibility.Public, name);
    }

    private JInterfaceBuilder() {
        super(JInterfaceDescriptor.class);
    }

}
