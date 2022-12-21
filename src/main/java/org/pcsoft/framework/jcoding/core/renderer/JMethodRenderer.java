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
    protected String doRenderContent(JMethodData data) {
        log.debug("Render method " + data.getName());
        return buildModifier(data) + " " + buildTypeReference(data)
                + " " + data.getName() + "(" + buildParameterList(data) + ")" + buildBody(data);
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

    private String buildTypeReference(JMethodData data) {
        if (data.getReturnType() == null)
            return "void";

        return JTypeReferenceRenderer.getInstance().renderToString(data.getReturnType());
    }

    private String buildParameterList(JMethodData data) {
        if (data.getParameters().isEmpty())
            return "";

        return data.getParameters().stream()
                .map(JParameterRenderer.getInstance()::renderToString)
                .collect(Collectors.joining(", "));
    }

    private String buildBody(JMethodData data) {
        if (data.isAbstract())
            return ";";

        return " {" + System.lineSeparator()
                + "}";
    }
}
