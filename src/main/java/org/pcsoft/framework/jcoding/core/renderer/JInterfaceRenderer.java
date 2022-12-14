package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JInterfaceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JTypeRenderer;

@Slf4j
public final class JInterfaceRenderer extends JTypeRenderer<JInterfaceData> {
    @Override
    protected String doRenderContent(JInterfaceData data) {
        log.debug("Render interface " + data.getName());
        return data.getAccess().getModifier() + " interface " + data.getName() + " {" + System.lineSeparator()
                + "}";
    }
}
