package org.pcsoft.framework.jcoding.core.renderer;

import org.pcsoft.framework.jcoding.core.data.JFileData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

public final class JFileRenderer extends JRenderer<JFileData> {
    private final JPackageRenderer packageRenderer = new JPackageRenderer();

    @Override
    protected String doRender(JFileData data) {
        return packageRenderer.renderToString(data.getPackageData());
    }
}
