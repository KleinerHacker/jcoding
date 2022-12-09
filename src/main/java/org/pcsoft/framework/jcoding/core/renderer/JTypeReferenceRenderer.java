package org.pcsoft.framework.jcoding.core.renderer;

import org.pcsoft.framework.jcoding.core.data.JTypeReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

public final class JTypeReferenceRenderer extends JRenderer<JTypeReferenceData> {
    private final JPackageReferenceRenderer packageReferenceRenderer = new JPackageReferenceRenderer();

    @Override
    protected String doRender(JTypeReferenceData data) {
        return packageReferenceRenderer.renderToString(data.getPackageReference()) + "." + data.getName();
    }
}
