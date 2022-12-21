package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JParameterData;
import org.pcsoft.framework.jcoding.core.renderer.base.JAnnotatableRenderer;

@Slf4j
public final class JParameterRenderer extends JAnnotatableRenderer<JParameterData> {
    private static final JParameterRenderer instance = new JParameterRenderer();

    public static JParameterRenderer getInstance() {
        return instance;
    }

    private JParameterRenderer() {
    }

    @Override
    protected String doRenderContent(int indent, JParameterData data) {
        log.debug("Render parameter " + data.getName());
        return (data.isFinal() ? "final " : "") + JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, data.getType()) + " " + data.getName();
    }
}
