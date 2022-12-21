package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JParameterData;
import org.pcsoft.framework.jcoding.core.renderer.base.JAnnotatableRenderer;

@Slf4j
public final class JParameterRenderer extends JAnnotatableRenderer<JParameterData> {
    private final JTypeReferenceRenderer typeReferenceRenderer = new JTypeReferenceRenderer();

    @Override
    protected String doRenderContent(JParameterData data) {
        log.debug("Render parameter " + data.getName());
        return (data.isFinal() ? "final " : "") + typeReferenceRenderer.renderToString(data.getType()) + " " + data.getName();
    }
}
