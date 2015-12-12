package org.pcsoft.framework.jcoding;

import org.junit.Test;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.*;
import org.pcsoft.framework.jcoding.processor.JCodingProcessorFactory;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public class JCodingTest {

    @Test
    public void test() throws JCodingException {
        final JClassDescriptor testClass = JClassBuilder.create("TestClass").withAbstract(true)
                .withGeneric(JGenericBuilder.create("T").withClassExtension(JTypeReferenceBuilder.create(String.class)))
                .withSuperClass(JExternalClassReferenceBuilder.create(ArrayList.class))
                .withInterface(JExternalInterfaceReferenceBuilder.create(Serializable.class))
                .build();

        final JFileDescriptor fileDescriptor = JFileBuilder.create("TestClass")
                .withPackage("org.pcsoft.framework.jcoding.test")
                .withJavaType(testClass)
                .build();

        final String javaCode = JCoding.generateCode(fileDescriptor, JCodingProcessorFactory.JAVA_PROCESSOR_FACTORY);
        System.out.println(javaCode);
    }

}
