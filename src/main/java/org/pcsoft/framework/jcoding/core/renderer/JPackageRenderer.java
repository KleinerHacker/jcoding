package org.pcsoft.framework.jcoding.core.renderer;

import org.pcsoft.framework.jcoding.core.data.JPackageData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

import java.util.stream.Collectors;

public final class JPackageRenderer extends JRenderer<JPackageData> {
    private final JAnnotationReferenceRender annotationReferenceRender = new JAnnotationReferenceRender();

    @Override
    protected String doRender(JPackageData data) {
        var annotationCode = data.getAnnotationReferences().stream()
                .map(annotationReferenceRender::renderToString)
                .collect(Collectors.joining("\n"));

        return annotationCode + "\npackage " + data.getName() + ";";
    }
}
