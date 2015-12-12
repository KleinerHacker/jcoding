package org.pcsoft.framework.jcoding.exception;

/**
 * Exception while generating java code from descriptor tree.
 */
public class JCodingGenerationException extends JCodingException {

    public JCodingGenerationException() {
    }

    public JCodingGenerationException(String message) {
        super(message);
    }

    public JCodingGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public JCodingGenerationException(Throwable cause) {
        super(cause);
    }
}
