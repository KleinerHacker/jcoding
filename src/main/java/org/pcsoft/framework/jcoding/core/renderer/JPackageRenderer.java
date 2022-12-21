package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JPackageData;
import org.pcsoft.framework.jcoding.core.renderer.base.JAnnotatableRenderer;

@Slf4j
public final class JPackageRenderer extends JAnnotatableRenderer<JPackageData> {
    private static final JPackageRenderer instance = new JPackageRenderer();

    public static JPackageRenderer getInstance() {
        return instance;
    }

    private JPackageRenderer() {
    }
    @Override
    protected String doRenderContent(int indent, JPackageData data) {
        log.debug("Render package " + data.getName());
        return buildIndent(indent) + "package " + data.getName() + ";";
    }
}
