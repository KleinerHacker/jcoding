package org.pcsoft.framework.jcoding.processor;

/**
 * Factory interface for generating a code processor, see {@link JCodingProcessor}.<br/>
 * All Builtin-Processors you can get via {@link JCodingBuiltinProcessors}.
 */
public interface JCodingProcessorFactory {

    /**
     * Returns the processor implementation
     * @return
     */
    JCodingProcessor getProcessor();

}
