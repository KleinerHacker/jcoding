package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JMethodData;
import org.pcsoft.framework.jcoding.core.renderer.base.JMemberRenderer;

import java.util.stream.Collectors;

@Slf4j
public final class JMethodRenderer extends JMemberRenderer<JMethodData> {
    private static final JMethodRenderer instance = new JMethodRenderer();

    public static JMethodRenderer getInstance() {
        return instance;
    }

    private JMethodRenderer() {
    }

    @Override
    protected String doRenderContent(int indent, JMethodData data) {
        log.trace("Render method " + data.getName());
        return buildIndent(indent) + buildModifier(data) + " " + buildTypeReference(indent, data)
                + " " + data.getName() + "(" + buildParameterList(indent, data) + ")" + buildBody(indent, data);
    }

    @Override
    protected String buildModifier(JMethodData data) {
        final var modifier = super.buildModifier(data);
        if (data.isFinal())
            return modifier + " final";
        if (data.isAbstract())
            return modifier + " abstract";

        return modifier;
    }

    private String buildTypeReference(int indent, JMethodData data) {
        if (data.getReturnType() == null)
            return "void";

        return JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, data.getReturnType());
    }

    private String buildParameterList(int indent, JMethodData data) {
        if (data.getParameters().isEmpty())
            return "";

        return data.getParameters().stream()
                .map(x -> JParameterRenderer.getInstance().renderUntrimmedToString(indent, x))
                .collect(Collectors.joining(", "));
    }

    private String buildBody(int indent, JMethodData data) {
        if (data.isAbstract())
            return ";";

        return " {" + System.lineSeparator()
                + buildIndent(indent) + "}";
    }
}
