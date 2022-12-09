package org.pcsoft.framework.jcoding.core.renderer;

import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

import java.util.stream.Collectors;

public final class JAnnotationReferenceRender extends JRenderer<JAnnotationReferenceData> {
    private final JTypeReferenceRenderer typeReferenceRenderer = new JTypeReferenceRenderer();
    private final JParameterReferenceRenderer parameterReferenceRenderer = new JParameterReferenceRenderer();

    @Override
    protected String doRender(JAnnotationReferenceData data) {
        return "@" + typeReferenceRenderer.renderToString(data.getType()) + "(" +
                data.getParameterReferences().stream()
                        .map(parameterReferenceRenderer::renderToString)
                        .collect(Collectors.joining(", "))
                + ")";
    }
}
