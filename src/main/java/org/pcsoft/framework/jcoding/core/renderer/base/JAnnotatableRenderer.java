package org.pcsoft.framework.jcoding.core.renderer.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JAnnotatableData;
import org.pcsoft.framework.jcoding.core.renderer.JAnnotationReferenceRender;

import java.util.stream.Collectors;

@Slf4j
public abstract class JAnnotatableRenderer<T extends JAnnotatableData> extends JNamedRenderer<T> {

    @Override
    protected final String doRender(T data) {
        log.debug("Render annotatable object " + data.getName());
        return data.getAnnotationReferences().stream()
                .map(JAnnotationReferenceRender.getInstance()::renderToString)
                .collect(Collectors.joining(System.lineSeparator())) +
                System.lineSeparator() + doRenderContent(data);
    }

    protected abstract String doRenderContent(T data);
}
