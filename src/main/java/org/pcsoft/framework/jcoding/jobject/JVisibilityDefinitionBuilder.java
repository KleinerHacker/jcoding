package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JVisibilityDefinitionBuilder<T extends JVisibilityDefinitionDescriptor, S extends JVisibilityDefinitionBuilder> extends JDefinitionBuilder<T, S> {

    public JVisibilityDefinitionBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withVisibility(final JVisibility visibility) {
        value.setVisibility(visibility);
        return (S)this;
    }
}
