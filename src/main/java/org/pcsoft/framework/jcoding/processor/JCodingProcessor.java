package org.pcsoft.framework.jcoding.processor;

import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.JFileDescriptor;

/**
 * Represent the basic interface for a language specific code processor.
 */
public interface JCodingProcessor {

    /**
     * Generate the source code from the descriptor tree.
     * @param fileDescriptor Root element of descriptor tree.
     * @return
     */
    String generateCode(final JFileDescriptor fileDescriptor) throws JCodingException;

}
