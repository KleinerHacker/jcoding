package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JClassData;
import org.pcsoft.framework.jcoding.core.renderer.base.JAnnotatableRenderer;

@Slf4j
public final class JClassRenderer extends JAnnotatableRenderer<JClassData> {
    @Override
    protected String doRenderContent(JClassData data) {
        log.debug("Render class " + data.getName());
        return buildModifier(data) + " class " + data.getName() + " {" + System.lineSeparator() + "}";
    }

    private String buildModifier(JClassData data) {
        var modifiers = data.getAccess().getModifier();
        if (data.isStatic())
            return modifiers + " static";
        else if (data.isAbstract())
            return modifiers + " abstract";
        else if (data.isFinal())
            return modifiers + " final";

        return modifiers;
    }
}
