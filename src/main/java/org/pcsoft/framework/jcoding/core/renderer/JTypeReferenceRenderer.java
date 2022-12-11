package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JNamedRenderer;

@Slf4j
public final class JTypeReferenceRenderer extends JNamedRenderer<JTypeReferenceData> {
    private final JPackageReferenceRenderer packageReferenceRenderer = new JPackageReferenceRenderer();

    @Override
    protected String doRender(JTypeReferenceData data) {
        log.debug("Render package reference " + data.getName());
        return packageReferenceRenderer.renderToString(data.getPackageReference()) + "." + data.getName();
    }
}
