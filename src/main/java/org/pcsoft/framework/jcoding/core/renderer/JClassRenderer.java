package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JClassData;
import org.pcsoft.framework.jcoding.core.renderer.base.JTypeRenderer;

import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
public final class JClassRenderer extends JTypeRenderer<JClassData> {
    private static final JClassRenderer instance = new JClassRenderer();

    public static JClassRenderer getInstance() {
        return instance;
    }

    private JClassRenderer() {
    }

    @Override
    protected String doRenderBody(int indent, JClassData data, Supplier<String> bodyContent) {
        log.debug("Render class " + data.getName());
        return buildIndent(indent) + buildModifier(data) + " class " + data.getName() + buildExtensions(indent, data) + " {" + System.lineSeparator()
                + bodyContent.get() + System.lineSeparator()
                + buildIndent(indent) + "}";
    }

    @Override
    protected String buildModifier(JClassData data) {
        var modifiers = super.buildModifier(data);
        if (data.isAbstract())
            return modifiers + " abstract";
        else if (data.isFinal())
            return modifiers + " final";

        return modifiers;
    }

    private String buildExtensions(int intend, JClassData data) {
        if (data.getSuperType() == null && data.getSuperInterfaces().isEmpty())
            return "";

        final var sb = new StringBuilder();
        if (data.getSuperType() != null) {
            sb.append(" extends ")
                    .append(JTypeReferenceRenderer.getInstance().renderUntrimmedToString(intend, data.getSuperType()));
        }
        if (!data.getSuperInterfaces().isEmpty()) {
            sb.append(" implements ")
                    .append(
                            data.getSuperInterfaces().stream()
                                    .map(x -> JTypeReferenceRenderer.getInstance().renderUntrimmedToString(intend, x))
                                    .collect(Collectors.joining(", "))
                    );
        }

        return sb.toString();
    }
}
