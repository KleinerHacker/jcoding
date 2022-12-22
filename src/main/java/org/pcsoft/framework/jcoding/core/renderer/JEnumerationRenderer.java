package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JEnumerationData;
import org.pcsoft.framework.jcoding.core.renderer.base.JTypeRenderer;

import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
public final class JEnumerationRenderer extends JTypeRenderer<JEnumerationData> {
    private static final JEnumerationRenderer instance = new JEnumerationRenderer();

    public static JEnumerationRenderer getInstance() {
        return instance;
    }

    private JEnumerationRenderer() {
    }

    @Override
    protected String doRenderBody(int indent, JEnumerationData data, Supplier<String> bodyContent) {
        log.debug("Render enumeration " + data.getName());
        return buildIndent(indent) + data.getAccess().getModifier() + " enum " + data.getName() + buildExtensions(indent, data) + " {" + System.lineSeparator()
                + bodyContent.get() + System.lineSeparator()
                + buildIndent(indent) + "}";
    }

    private String buildExtensions(int indent, JEnumerationData data) {
        if (data.getSuperInterfaces().isEmpty())
            return "";

        return " implements " + data.getSuperInterfaces().stream()
                .map(x -> JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, x))
                .collect(Collectors.joining(", "));
    }
}
