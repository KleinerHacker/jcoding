package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JGenericData;
import org.pcsoft.framework.jcoding.core.renderer.base.JNamedRenderer;

@Slf4j
public final class JGenericRenderer extends JNamedRenderer<JGenericData> {
    private static final JGenericRenderer instance = new JGenericRenderer();

    public static JGenericRenderer getInstance() {
        return instance;
    }

    private JGenericRenderer() {
    }

    @Override
    protected String doRender(int indent, JGenericData data) {
        log.trace("Render generic " + data.getName());
        return data.getName() + buildExtensions(indent, data);
    }

    private String buildExtensions(int indent, JGenericData data) {
        if (data.getExtendsType() != null)
            return " extends " + JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, data.getExtendsType());
        if (data.getSuperType() != null)
            return " super " + JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, data.getSuperType());

        return "";
    }
}
