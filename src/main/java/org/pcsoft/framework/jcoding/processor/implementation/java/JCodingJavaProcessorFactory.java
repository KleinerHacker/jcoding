package org.pcsoft.framework.jcoding.processor.implementation.java;

import org.pcsoft.framework.jcoding.processor.JCodingProcessor;
import org.pcsoft.framework.jcoding.processor.JCodingProcessorFactory;

/**
 * Created by pfeifchr on 11.12.2015.
 */
public class JCodingJavaProcessorFactory implements JCodingProcessorFactory {
    private static final JCodingProcessor PROCESSOR = new JCodingJavaProcessor();

    @Override
    public JCodingProcessor getProcessor() {
        return PROCESSOR;
    }
}
