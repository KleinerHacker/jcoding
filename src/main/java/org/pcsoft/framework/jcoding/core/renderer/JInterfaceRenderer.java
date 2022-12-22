package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JInterfaceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JTypeRenderer;

import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
public final class JInterfaceRenderer extends JTypeRenderer<JInterfaceData> {
    private static final JInterfaceRenderer instance = new JInterfaceRenderer();

    public static JInterfaceRenderer getInstance() {
        return instance;
    }

    private JInterfaceRenderer() {
    }

    @Override
    protected String doRenderBody(int indent, JInterfaceData data, Supplier<String> bodyContent) {
        log.debug("Render interface " + data.getName());
        return buildIndent(indent) + data.getAccess().getModifier() + " interface " + data.getName() + buildExtensions(indent, data) + " {" + System.lineSeparator()
                + bodyContent.get() + System.lineSeparator()
                + buildIndent(indent) + "}";
    }

    private String buildExtensions(int indent, JInterfaceData data) {
        if (data.getSuperInterfaces().isEmpty())
            return "";

        return " extends " + data.getSuperInterfaces().stream()
                .map(x -> JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, x))
                .collect(Collectors.joining(", "));
    }
}
