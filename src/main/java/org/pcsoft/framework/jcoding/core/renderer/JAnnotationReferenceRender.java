package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

import java.util.stream.Collectors;

@Slf4j
public final class JAnnotationReferenceRender extends JRenderer<JAnnotationReferenceData> {
    private static final JAnnotationReferenceRender instance = new JAnnotationReferenceRender();

    public static JAnnotationReferenceRender getInstance() {
        return instance;
    }

    private JAnnotationReferenceRender() {
    }

    @Override
    protected String doRender(JAnnotationReferenceData data) {
        log.debug("Render annotation reference " + data.getType());
        return "@" + JTypeReferenceRenderer.getInstance().renderToString(data.getType()) + "(" +
                data.getParameterReferences().stream()
                        .map(JParameterReferenceRenderer.getInstance()::renderToString)
                        .collect(Collectors.joining(", "))
                + ")";
    }
}
