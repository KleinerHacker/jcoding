package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JClassData;
import org.pcsoft.framework.jcoding.core.data.JFileData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

import java.util.stream.Collectors;

@Slf4j
public final class JFileRenderer extends JRenderer<JFileData> {
    private final JPackageRenderer packageRenderer = new JPackageRenderer();
    private final JClassRenderer classRenderer = new JClassRenderer();

    @Override
    protected String doRender(JFileData data) {
        log.debug("Render file " + data.getName());
        return packageRenderer.renderToString(data.getPackageData()) + System.lineSeparator() +
                //Classes
                data.getTypes().stream()
                        .filter(x -> x instanceof JClassData)
                        .map(x -> (JClassData) x)
                        .map(classRenderer::renderToString)
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
