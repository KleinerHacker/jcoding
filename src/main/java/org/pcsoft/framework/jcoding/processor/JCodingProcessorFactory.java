package org.pcsoft.framework.jcoding.processor;

/**
 * Factory interface for generating a code processor, see {@link JCodingProcessor}
 */
public interface JCodingProcessorFactory {
    /**
     * Default builtin Java Processor Factory
     */
    public static final JCodingProcessorFactory JAVA_PROCESSOR_FACTORY = new JCodingJavaProcessorFactory();

    JCodingProcessor getProcessor();

}
