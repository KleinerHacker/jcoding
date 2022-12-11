package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JPackageData;
import org.pcsoft.framework.jcoding.core.renderer.base.JAnnotatableRenderer;

@Slf4j
public final class JPackageRenderer extends JAnnotatableRenderer<JPackageData> {
    @Override
    protected String doRenderContent(JPackageData data) {
        log.debug("Render package " + data.getName());
        return "package " + data.getName() + ";";
    }
}
