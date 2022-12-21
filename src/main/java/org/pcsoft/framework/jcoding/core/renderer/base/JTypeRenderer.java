package org.pcsoft.framework.jcoding.core.renderer.base;

import org.apache.commons.lang3.StringUtils;
import org.pcsoft.framework.jcoding.core.data.*;
import org.pcsoft.framework.jcoding.core.data.base.JMemberData;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;
import org.pcsoft.framework.jcoding.core.renderer.*;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class JTypeRenderer<T extends JTypeData> extends JMemberRenderer<T> {
    @Override
    protected final String doRenderContent(T data) {
        return doRenderBody(data, () -> //
                renderMember(JFieldData.class, data, JFieldRenderer.getInstance()::renderToString) //
                        + renderMember(JMethodData.class, data, JMethodRenderer.getInstance()::renderToString) //
                        + renderMember(JClassData.class, data, JClassRenderer.getInstance()::renderToString) //
                        + renderMember(JInterfaceData.class, data, JInterfaceRenderer.getInstance()::renderToString) //
                        + renderMember(JEnumerationData.class, data, JEnumerationRenderer.getInstance()::renderToString) //
        );
    }

    protected abstract String doRenderBody(T data, Supplier<String> bodyContent);

    @SuppressWarnings({"unchecked", "FunctionalExpressionCanBeFolded"})
    private <M extends JMemberData> String renderMember(Class<M> clazz, T data, Function<M, String> renderer) {
        final var s = data.getMembers().stream() //
                .filter(x -> clazz.isAssignableFrom(x.getClass())) //
                .map(x -> (M) x) //
                .map(renderer::apply) //
                .collect(Collectors.joining(System.lineSeparator()));

        if (StringUtils.isBlank(s))
            return "";

        return s + System.lineSeparator();
    }
}
