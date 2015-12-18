package org.pcsoft.framework.jcoding;

import org.junit.Test;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.*;
import org.pcsoft.framework.jcoding.jobject.type.JClassReference;
import org.pcsoft.framework.jcoding.jobject.type.JInterfaceReference;
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
                .withGeneric(JGenericBuilder.create("T").withClassExtension(JTypeReferenceBuilder.create(JClassReference.create(String.class))))
                .withSuperClass(JClassReferenceBuilder.create(JClassReference.create(ArrayList.class)))
                .withInterface(JInterfaceReferenceBuilder.create(JInterfaceReference.create(Serializable.class)))
                .withMethods(
                        JStandardMethodBuilder.create("create").withStatic(true)
                                .withParameters(
                                        JParameterBuilder.create("key", JTypeReferenceBuilder.create(JClassReference.create(String.class))).withFinal(true),
                                        JParameterBuilder.create("value", JTypeReferenceBuilder.create(JClassReference.create(int.class))).withFinal(true)
                                )
                                .withBody(JMethodBodyBuilder.create()),
                        JStandardMethodBuilder.create("getKey", JTypeReferenceBuilder.create(JClassReference.create(String.class)))
                                .withBody(JMethodBodyBuilder.create()),
                        JStandardMethodBuilder.create("getValue", JTypeReferenceBuilder.create(JClassReference.create(int.class)))
                                .withBody(JMethodBodyBuilder.create()),
                        JStandardMethodBuilder.create(JVisibility.Protected, "validate", (JTypeReferenceDescriptor) null)
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
