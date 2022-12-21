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
    protected final String doRenderContent(int indent, T data) {
        return doRenderBody(indent, data, () -> //
                renderMember(JFieldData.class, data, x -> JFieldRenderer.getInstance().renderUntrimmedToString(indent + 1, x)) //
                        + renderMember(JMethodData.class, data, x -> JMethodRenderer.getInstance().renderUntrimmedToString(indent + 1, x)) //
                        + renderMember(JClassData.class, data, x -> JClassRenderer.getInstance().renderUntrimmedToString(indent + 1, x)) //
                        + renderMember(JInterfaceData.class, data, x -> JInterfaceRenderer.getInstance().renderUntrimmedToString(indent + 1, x)) //
                        + renderMember(JEnumerationData.class, data, x -> JEnumerationRenderer.getInstance().renderUntrimmedToString(indent + 1, x)) //
        );
    }

    protected abstract String doRenderBody(int indent, T data, Supplier<String> bodyContent);

    @SuppressWarnings({"unchecked", "FunctionalExpressionCanBeFolded"})
    private <M extends JMemberData> String renderMember(Class<M> clazz, T data, Function<M, String> renderer) {
        final var s = data.getMembers().stream() //
                .filter(x -> clazz.isAssignableFrom(x.getClass())) //
                .map(x -> (M) x) //
                .map(renderer::apply) //
                .collect(Collectors.joining(System.lineSeparator()));

        if (StringUtils.isBlank(s))
            return "";

        return System.lineSeparator() + s + System.lineSeparator();
    }
}
