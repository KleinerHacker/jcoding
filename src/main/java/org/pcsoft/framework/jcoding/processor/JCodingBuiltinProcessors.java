package org.pcsoft.framework.jcoding.processor;

import org.pcsoft.framework.jcoding.processor.implementation.java.JCodingJavaProcessorFactory;

/**
 * Contains the builtin processor factories.
 */
public final class JCodingBuiltinProcessors {
    /**
     * Default builtin Java Processor Factory
     */
    public static final JCodingProcessorFactory JAVA_PROCESSOR_FACTORY = new JCodingJavaProcessorFactory();

    private JCodingBuiltinProcessors() {
    }
}
