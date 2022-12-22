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
    protected String doRender(int indent, JAnnotationReferenceData data) {
        log.trace("Render annotation reference " + data.getType());
        return buildIndent(indent) + "@" + JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, data.getType()) + "(" +
                data.getParameterReferences().stream()
                        .map(x -> JParameterReferenceRenderer.getInstance().renderUntrimmedToString(indent, x))
                        .collect(Collectors.joining(", "))
                + ")";
    }
}
