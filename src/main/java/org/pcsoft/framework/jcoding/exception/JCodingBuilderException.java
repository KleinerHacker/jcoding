package org.pcsoft.framework.jcoding.exception;

import org.pcsoft.framework.jcoding.jobject.JObjectBuilder;

/**
 * Exception for failures in builder, see {@link JObjectBuilder}
 */
public class JCodingBuilderException extends JCodingException {

    public JCodingBuilderException() {
    }

    public JCodingBuilderException(String message) {
        super(message);
    }

    public JCodingBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public JCodingBuilderException(Throwable cause) {
        super(cause);
    }
}
