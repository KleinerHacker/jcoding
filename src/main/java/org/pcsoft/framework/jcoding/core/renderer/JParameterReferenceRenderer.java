package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JParameterReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JNamedRenderer;
import org.pcsoft.framework.jcoding.core.utils.ObjectConverter;

@Slf4j
public final class JParameterReferenceRenderer extends JNamedRenderer<JParameterReferenceData> {
    private static final JParameterReferenceRenderer instance = new JParameterReferenceRenderer();

    public static JParameterReferenceRenderer getInstance() {
        return instance;
    }

    private JParameterReferenceRenderer() {
    }

    @Override
    protected String doRender(JParameterReferenceData data) {
        log.debug("Render parameter reference " + data.getName());
        return data.getName() + " = " + ObjectConverter.generateObjectString(data.getValue());
    }
}
