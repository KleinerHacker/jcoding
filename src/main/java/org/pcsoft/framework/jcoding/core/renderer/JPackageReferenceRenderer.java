package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JPackageReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JNamedRenderer;

@Slf4j
public final class JPackageReferenceRenderer extends JNamedRenderer<JPackageReferenceData> {
    private static final JPackageReferenceRenderer instance = new JPackageReferenceRenderer();

    public static JPackageReferenceRenderer getInstance() {
        return instance;
    }

    private JPackageReferenceRenderer() {
    }

    @Override
    protected String doRender(int indent, JPackageReferenceData data) {
        log.trace("Render package reference " + data.getName());
        return data.getName();
    }
}
