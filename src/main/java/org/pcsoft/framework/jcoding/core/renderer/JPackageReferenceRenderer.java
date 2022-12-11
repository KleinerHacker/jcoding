package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JPackageReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JNamedRenderer;

@Slf4j
public final class JPackageReferenceRenderer extends JNamedRenderer<JPackageReferenceData> {
    @Override
    protected String doRender(JPackageReferenceData data) {
        log.debug("Render package reference " + data.getName());
        return data.getName();
    }
}
