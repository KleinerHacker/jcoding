package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JFieldData;
import org.pcsoft.framework.jcoding.core.renderer.base.JMemberRenderer;
import org.pcsoft.framework.jcoding.core.utils.ObjectConverter;

@Slf4j
public final class JFieldRenderer extends JMemberRenderer<JFieldData> {
    private static final JFieldRenderer instance = new JFieldRenderer();

    public static JFieldRenderer getInstance() {
        return instance;
    }

    private JFieldRenderer() {
    }

    @Override
    protected String doRenderContent(int indent, JFieldData data) {
        log.debug("Render field " + data.getName());
        return buildIndent(indent) + buildModifier(data) + " " + JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, data.getType()) + " " + data.getName() + buildValue(data) + ";";
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
