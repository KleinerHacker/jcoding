package org.pcsoft.framework.jcoding.core.renderer;

import org.pcsoft.framework.jcoding.core.data.JPackageReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

public final class JPackageReferenceRenderer extends JRenderer<JPackageReferenceData> {
    @Override
    protected String doRender(JPackageReferenceData data) {
        return data.getName();
    }
}
