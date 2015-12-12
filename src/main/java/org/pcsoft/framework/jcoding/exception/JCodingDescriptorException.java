package org.pcsoft.framework.jcoding.exception;

import org.pcsoft.framework.jcoding.jobject.JObjectDescriptor;

/**
 * Exception for failures in descriptor, see {@link JObjectDescriptor}
 */
public class JCodingDescriptorException extends JCodingException {

    public JCodingDescriptorException() {
    }

    public JCodingDescriptorException(String message) {
        super(message);
    }

    public JCodingDescriptorException(String message, Throwable cause) {
        super(message, cause);
    }

    public JCodingDescriptorException(Throwable cause) {
        super(cause);
    }
}
