package org.pcsoft.framework.jcoding.core.renderer;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JParameterReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JNamedRenderer;

@Slf4j
public final class JParameterReferenceRenderer extends JNamedRenderer<JParameterReferenceData> {
    @Override
    protected String doRender(JParameterReferenceData data) {
        log.debug("Render parameter reference " + data.getName());
        return data.getName() + " = " + generateObjectString(data.getValue());
    }

    private static String generateObjectString(Object value) {
        if (value instanceof String) {
            return "\"" + value + "\"";
        } else if (value instanceof Character) {
            return "'" + value + "'";
        } else if (value instanceof Double) {
            return value + "d";
        } else if (value instanceof Float) {
            return value + "f";
        } else if (value instanceof Class) {
            return ((Class<?>) value).getCanonicalName() + ".class";
        } else if (value instanceof Long) {
            return value + "L";
        } else if (value instanceof Enum) {
            return value.getClass().getCanonicalName() + "." + value;
        }

        return value == null ? "null" : value.toString();
    }
}
