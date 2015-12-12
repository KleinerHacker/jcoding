package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.JCoding;
import org.pcsoft.framework.jcoding.exception.JCodingGenerationException;
import org.pcsoft.framework.jcoding.management.ImportManagement;

/**
 * Represent the interface for a java reference object descriptor, based on {@link JObjectDescriptor}.
 */
public interface JReferenceDescriptor extends JObjectDescriptor {

    /**
     * <b>Only for internal use!</b><br/>
     * Process the optional imports for the concrete java object. This method is called by {@link JCoding} itself.
     * @param importManagement The import management object to handle own imports
     * @throws JCodingGenerationException
     */
    void processImports(final ImportManagement importManagement) throws JCodingGenerationException;
}
