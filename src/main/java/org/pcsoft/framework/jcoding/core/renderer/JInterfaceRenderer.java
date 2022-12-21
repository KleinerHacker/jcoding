package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JInterfaceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JTypeRenderer;

import java.util.function.Supplier;

@Slf4j
public final class JInterfaceRenderer extends JTypeRenderer<JInterfaceData> {
    private static final JInterfaceRenderer instance = new JInterfaceRenderer();

    public static JInterfaceRenderer getInstance() {
        return instance;
    }

    private JInterfaceRenderer() {
    }

    @Override
    protected String doRenderBody(JInterfaceData data, Supplier<String> bodyContent) {
        log.debug("Render interface " + data.getName());
        return data.getAccess().getModifier() + " interface " + data.getName() + " {" + System.lineSeparator()
                + bodyContent.get() + System.lineSeparator()
                + "}";
    }
}
