package org.pcsoft.framework.jcoding.processor.implementation.java;

import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 11.12.2015.
 */
final class JCodingJavaProcessorUtils {

    public static String convert(JVisibility visibility) {
        switch (visibility) {
            case Private:
                return "private";
            case PackageInternal:
            case Default:
                return "";
            case Protected:
                return "protected";
            case Public:
                return "public";
            default:
                throw new RuntimeException();
        }
    }

    private JCodingJavaProcessorUtils() {
    }
}
