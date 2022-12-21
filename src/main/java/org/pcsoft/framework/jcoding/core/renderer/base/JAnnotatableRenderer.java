package org.pcsoft.framework.jcoding.core.renderer.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.pcsoft.framework.jcoding.core.data.base.JAnnotatableData;
import org.pcsoft.framework.jcoding.core.renderer.JAnnotationReferenceRender;

import java.util.stream.Collectors;

@Slf4j
public abstract class JAnnotatableRenderer<T extends JAnnotatableData> extends JNamedRenderer<T> {

    @Override
    protected final String doRender(int indent, T data) {
        log.debug("Render annotatable object " + data.getName());
        return buildAnnotations(indent, data) + doRenderContent(indent, data);
    }

    protected abstract String doRenderContent(int indent, T data);

    private String buildAnnotations(int indent, T data) {
        final var s = data.getAnnotationReferences().stream()
                .map(x -> JAnnotationReferenceRender.getInstance().renderUntrimmedToString(indent, x))
                .collect(Collectors.joining(System.lineSeparator()));
        if (StringUtils.isBlank(s))
            return "";

        return s + System.lineSeparator();
    }
}
