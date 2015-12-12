package org.pcsoft.framework.jcoding.processor;

import org.apache.commons.lang.StringUtils;

/**
 * Utils for processing code
 */
public final class JCodingProcessorUtils {

    private static final int INDENT_SIZE = 4;

    public static String buildIndent(final int level) {
        return StringUtils.repeat(" ", level * INDENT_SIZE);
    }

    private JCodingProcessorUtils() {
    }
}
