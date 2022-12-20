package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JFieldData;
import org.pcsoft.framework.jcoding.core.renderer.base.JMemberRenderer;
import org.pcsoft.framework.jcoding.core.utils.ObjectConverter;

@Slf4j
public final class JFieldRenderer extends JMemberRenderer<JFieldData> {
    private final JTypeReferenceRenderer typeReferenceRenderer = new JTypeReferenceRenderer();

    @Override
    protected String doRenderContent(JFieldData data) {
        log.debug("Render field " + data.getName());
        return buildModifier(data) + " " + typeReferenceRenderer.renderToString(data.getType()) + " " + data.getName() + buildValue(data);
    }

    @Override
    protected String buildModifier(JFieldData data) {
        var modifiers = super.buildModifier(data);
        if (data.isFinal())
            return modifiers + " final";

        return modifiers;
    }

    private String buildValue(JFieldData data) {
        if (!data.isHasDirectInitialization())
            return "";

        return " = " + ObjectConverter.generateObjectString(data.getValue());
    }
}