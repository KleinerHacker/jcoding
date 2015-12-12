package org.pcsoft.framework.jcoding.processor;

/**
 * Created by pfeifchr on 11.12.2015.
 */
class JCodingJavaProcessorFactory implements JCodingProcessorFactory {
    private static final JCodingProcessor PROCESSOR = new JCodingJavaProcessor();

    @Override
    public JCodingProcessor getProcessor() {
        return PROCESSOR;
    }
}
