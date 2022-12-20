package org.pcsoft.framework.jcoding.core.renderer;

import org.pcsoft.framework.jcoding.core.data.JMethodData;
import org.pcsoft.framework.jcoding.core.renderer.base.JMemberRenderer;

public final class JMethodRenderer extends JMemberRenderer<JMethodData> {
    private final JTypeReferenceRenderer typeReferenceRenderer = new JTypeReferenceRenderer();

    @Override
    protected String doRenderContent(JMethodData data) {
        return buildModifier(data) + " " + buildTypeReference(data)
                + " " + data.getName() + "()" + buildBody(data);
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

        return typeReferenceRenderer.renderToString(data.getReturnType());
    }

    private String buildBody(JMethodData data) {
        if (data.isAbstract())
            return ";";

        return " {" + System.lineSeparator()
                + "}";
    }
}
