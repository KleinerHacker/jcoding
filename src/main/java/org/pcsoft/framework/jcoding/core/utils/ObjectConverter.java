package org.pcsoft.framework.jcoding.core.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ObjectConverter {

    public static String generateObjectString(Object value) {
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
