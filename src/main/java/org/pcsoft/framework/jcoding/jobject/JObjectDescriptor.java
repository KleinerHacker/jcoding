package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

/**
 * Represent the base for all java object descriptors.<br/>
 * <br/>
 * Contains all set data for this object.
 */
public interface JObjectDescriptor {

    /**
     * Validate the concrete object for needed and correct set parameters. If the validation failed a
     * {@link JCodingDescriptorValidationException} is thrown.
     * @throws JCodingDescriptorValidationException Is thrown if the validation failed.
     */
    void validate() throws JCodingDescriptorValidationException;

}
