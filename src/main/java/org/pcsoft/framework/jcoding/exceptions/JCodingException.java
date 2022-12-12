package org.pcsoft.framework.jcoding.exceptions;

public abstract class JCodingException extends RuntimeException {

    public JCodingException(String message) {
        super(message);
    }

    public JCodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
