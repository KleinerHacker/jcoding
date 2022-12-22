package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JNamedRenderer;

import java.util.stream.Collectors;

@Slf4j
public final class JTypeReferenceRenderer extends JNamedRenderer<JTypeReferenceData> {
    private static final JTypeReferenceRenderer instance = new JTypeReferenceRenderer();

    public static JTypeReferenceRenderer getInstance() {
        return instance;
    }

    private JTypeReferenceRenderer() {
    }

    @Override
    protected String doRender(int indent, JTypeReferenceData data) {
        log.trace("Render package reference " + data.getName());
        return buildPackage(indent, data) + data.getName() + buildGenerics(indent, data);
    }

    private String buildPackage(int indent, JTypeReferenceData data) {
        if (data.getPackageReference() == null)
            return "";

        return JPackageReferenceRenderer.getInstance().renderUntrimmedToString(indent, data.getPackageReference()) + ".";
    }

    private String buildGenerics(int indent, JTypeReferenceData data) {
        if (data.getGenerics().isEmpty())
            return "";

        return "<" + data.getGenerics().stream()
                .map(x -> JTypeReferenceRenderer.getInstance().renderUntrimmedToString(indent, x))
                .collect(Collectors.joining(", ")) + ">";
    }
}
