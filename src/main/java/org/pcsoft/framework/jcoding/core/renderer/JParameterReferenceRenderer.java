package org.pcsoft.framework.jcoding.core.renderer;

import org.pcsoft.framework.jcoding.core.data.JParameterReferenceData;
import org.pcsoft.framework.jcoding.core.renderer.base.JRenderer;

public final class JParameterReferenceRenderer extends JRenderer<JParameterReferenceData> {
    @Override
    protected String doRender(JParameterReferenceData data) {
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
