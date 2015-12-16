package org.pcsoft.framework.jcoding;

import org.junit.Test;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.*;
import org.pcsoft.framework.jcoding.processor.JCodingBuiltinProcessors;
import org.pcsoft.framework.jcoding.type.JVisibility;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public class JCodingTest {

    @Test
    public void test() throws JCodingException {
        final JClassDescriptor testClass = JClassBuilder.create("TestClass").withAbstract(true)
                .withGeneric(JGenericBuilder.create("T").withClassExtension(JTypeReferenceBuilderBase.create(String.class)))
                .withSuperClass(JExternalClassReferenceBuilder.create(ArrayList.class))
                .withInterface(JExternalInterfaceReferenceBuilder.create(Serializable.class))
                .withMethods(
                        JStandardMethodBuilder.create("create").withStatic(true)
                                .withParameters(
                                        JParameterBuilder.create("key", JClassReferenceBuilder.create(String.class)).withFinal(true),
                                        JParameterBuilder.create("value", JClassReferenceBuilder.create(int.class)).withFinal(true)
                                )
                                .withBody(JMethodBodyBuilder.create()),
                        JStandardMethodBuilder.create("getKey", JExternalClassReferenceBuilder.create(String.class))
                                .withBody(JMethodBodyBuilder.create()),
                        JStandardMethodBuilder.create("getValue", JExternalClassReferenceBuilder.create(int.class))
                                .withBody(JMethodBodyBuilder.create()),
                        JStandardMethodBuilder.create(JVisibility.Protected, "validate", (JTypeReferenceDescriptorBase) null)
                )
                .build();

        final JFileDescriptor fileDescriptor = JFileBuilder.create("TestClass")
                .withPackage("org.pcsoft.framework.jcoding.test")
                .withJavaType(testClass)
                .build();

        final String javaCode = JCoding.generateCode(fileDescriptor, JCodingBuiltinProcessors.JAVA_PROCESSOR_FACTORY);
        System.out.println(javaCode);
    }

}
