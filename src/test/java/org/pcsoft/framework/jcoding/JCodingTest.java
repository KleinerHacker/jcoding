package org.pcsoft.framework.jcoding;

import org.junit.Test;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.JClassBuilder;
import org.pcsoft.framework.jcoding.jobject.JClassDescriptor;
import org.pcsoft.framework.jcoding.jobject.JFileBuilder;
import org.pcsoft.framework.jcoding.jobject.JFileDescriptor;
import org.pcsoft.framework.jcoding.processor.JCodingProcessorFactory;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public class JCodingTest {

    @Test
    public void test() throws JCodingException {
        final JClassDescriptor testClass = JClassBuilder.create("TestClass")
                .withFinal(true)
                .build();

        final JFileDescriptor fileDescriptor = JFileBuilder.create("TestClass")
                .withPackage("org.pcsoft.framework.jcoding.test")
                .withJavaType(testClass)
                .build();

        final String javaCode = JCoding.generateCode(fileDescriptor, JCodingProcessorFactory.JAVA_PROCESSOR_FACTORY);
        System.out.println(javaCode);
    }

}
