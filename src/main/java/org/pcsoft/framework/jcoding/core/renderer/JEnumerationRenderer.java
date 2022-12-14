package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JEnumerationData;
import org.pcsoft.framework.jcoding.core.renderer.base.JTypeRenderer;

@Slf4j
public final class JEnumerationRenderer extends JTypeRenderer<JEnumerationData> {
    @Override
    protected String doRenderContent(JEnumerationData data) {
        log.debug("Render enumeration " + data.getName());
        return data.getAccess().getModifier() + " enum " + data.getName() + " {" + System.lineSeparator()
                + "}";
    }
}
