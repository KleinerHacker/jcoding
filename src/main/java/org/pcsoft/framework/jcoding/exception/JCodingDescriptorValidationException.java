package org.pcsoft.framework.jcoding.exception;

import org.pcsoft.framework.jcoding.jobject.JObjectDescriptor;

/**
 * Exception for java descriptor validation, see {@link JObjectDescriptor#validate()}
 */
public class JCodingDescriptorValidationException extends JCodingDescriptorException {

    public JCodingDescriptorValidationException(String message) {
        super(message);
    }

    public JCodingDescriptorValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
