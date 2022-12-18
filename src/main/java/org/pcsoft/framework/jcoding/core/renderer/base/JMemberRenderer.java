package org.pcsoft.framework.jcoding.core.renderer.base;

import org.pcsoft.framework.jcoding.core.data.base.JMemberData;

public abstract class JMemberRenderer<T extends JMemberData> extends JAnnotatableRenderer<T> {
    protected String buildModifier(T data) {
        var modifiers = data.getAccess().getModifier();
        if (data.isStatic())
            return modifiers + " static";

        return modifiers;
    }
}
