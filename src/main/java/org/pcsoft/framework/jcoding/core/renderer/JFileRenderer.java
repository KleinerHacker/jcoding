package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.pcsoft.framework.jcoding.core.data.JClassData;
import org.pcsoft.framework.jcoding.core.data.JEnumerationData;
import org.pcsoft.framework.jcoding.core.data.JFileData;
import org.pcsoft.framework.jcoding.core.data.JInterfaceData;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public final class JFileRenderer extends JRenderer<JFileData> {
    private static final JFileRenderer instance = new JFileRenderer();

    public static JFileRenderer getInstance() {
        return instance;
    }

    private JFileRenderer() {
    }

    @Override
    protected String doRender(JFileData data) {
        log.debug("Render file " + data.getName());
        return JPackageRenderer.getInstance().renderToString(data.getPackageData()) + System.lineSeparator() //
                + renderType(JClassData.class, data, JClassRenderer.getInstance()::renderToString) //
                + renderType(JInterfaceData.class, data, JInterfaceRenderer.getInstance()::renderToString) //
                + renderType(JEnumerationData.class, data, JEnumerationRenderer.getInstance()::renderToString);
    }

    @SuppressWarnings({"FunctionalExpressionCanBeFolded", "unchecked"})
    private <T extends JTypeData> String renderType(Class<T> clazz, JFileData data, Function<T, String> renderer) {
        final var s = data.getTypes().stream() //
                .filter(x -> clazz.isAssignableFrom(x.getClass())) //
                .map(x -> (T) x) //
                .map(renderer::apply) //
                .collect(Collectors.joining(System.lineSeparator()));
        if (StringUtils.isBlank(s))
            return "";

        return s + System.lineSeparator();
    }
}
