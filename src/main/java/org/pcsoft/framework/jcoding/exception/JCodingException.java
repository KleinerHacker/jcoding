package org.pcsoft.framework.jcoding.exception;

/**
 * Base exception for all java coding failures.
 */
public abstract class JCodingException extends Exception {

    public JCodingException() {
    }

    public JCodingException(String message) {
        super(message);
    }

    public JCodingException(String message, Throwable cause) {
        super(message, cause);
    }

    public JCodingException(Throwable cause) {
        super(cause);
    }
}
