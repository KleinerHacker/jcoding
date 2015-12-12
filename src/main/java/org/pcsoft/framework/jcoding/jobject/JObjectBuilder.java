package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Represent the base for all java object builder.
 */
public interface JObjectBuilder<T extends JObjectDescriptor> {

    /**
     * Build the concrete java object with set values.
     * @return The object to build
     * @throws JCodingBuilderException Is thrown if the validation for the object to build has failed. See {@link JObjectDescriptor#validate()}
     */
    T build() throws JCodingBuilderException;

}
