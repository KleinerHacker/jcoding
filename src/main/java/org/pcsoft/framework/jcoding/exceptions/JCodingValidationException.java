package org.pcsoft.framework.jcoding.exceptions;

public class JCodingValidationException extends JCodingException{
    public JCodingValidationException() {
    }

    public JCodingValidationException(String message) {
        super(message);
    }

    public JCodingValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public JCodingValidationException(Throwable cause) {
        super(cause);
    }
}
