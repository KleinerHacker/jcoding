package org.pcsoft.framework.jcoding.processor;

/**
 * Factory interface for generating a code processor, see {@link JCodingProcessor}.<br/>
 */
public interface JCodingProcessorFactory {
    public static JCodingProcessorFactory getInstance() {
        return new JCodingProcessorFactory() {
            @Override
            public JCodingProcessor getProcessor() {
                return new JCodingProcessorImpl();
            }
        };
    }

    /**
     * Returns the processor implementation
     * @return
     */
    JCodingProcessor getProcessor();

}
