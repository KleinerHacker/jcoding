package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JNamedRenderer;

@Slf4j
public final class JTypeReferenceRenderer extends JNamedRenderer<JTypeReferenceData> {
    private static final JTypeReferenceRenderer instance = new JTypeReferenceRenderer();

    public static JTypeReferenceRenderer getInstance() {
        return instance;
    }

    private JTypeReferenceRenderer() {
    }

    @Override
    protected String doRender(JTypeReferenceData data) {
        log.debug("Render package reference " + data.getName());
        return buildPackage(data) + data.getName();
    }

    private String buildPackage(JTypeReferenceData data) {
        if (data.getPackageReference() == null)
            return "";

        return JPackageReferenceRenderer.getInstance().renderToString(data.getPackageReference()) + ".";
    }
}
