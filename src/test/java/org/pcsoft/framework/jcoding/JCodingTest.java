package org.pcsoft.framework.jcoding;

import org.junit.Test;
import org.pcsoft.framework.jcoding.exception.JCodingException;
import org.pcsoft.framework.jcoding.jobject.*;
import org.pcsoft.framework.jcoding.jobject.type.JClassReference;
import org.pcsoft.framework.jcoding.jobject.type.JInterfaceReference;
import org.pcsoft.framework.jcoding.processor.JCodingProcessorFactory;
import org.pcsoft.framework.jcoding.type.JNumberType;
import org.pcsoft.framework.jcoding.type.JVisibility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Simple Test for JCoding Framework
 */
public class JCodingTest {

    @Test
    public void test() throws JCodingException {
        final JGenericBuilder myListGeneric = JGenericBuilder.create("T")
                .withClassExtension(JClassReferenceBuilder.create(JClassReference.create(Comparator.class))
                        .withGeneric(JGenericValueBuilder.create(JTypeReferenceBuilder.create(JClassReference.create(String.class)))));
        final JClassReferenceBuilder myListSuperClass = JClassReferenceBuilder.create(JClassReference.create(ArrayList.class))
                .withGeneric(JGenericValueBuilder.create(JGenericReferenceBuilder.create(myListGeneric.build())).withWildcard(true));

        final JGenericBuilder myListClassStaticMethodGeneric = JGenericBuilder.create("S")
                .withInterfaceExtension(JInterfaceReferenceBuilder.create(JInterfaceReference.create(Serializable.class)));
        final JStandardMethodBuilder myListClassStaticMethod = JStandardMethodBuilder.create("create").withStatic(true)
                .withGeneric(myListClassStaticMethodGeneric)
                .withParameters(
                        JParameterBuilder.create("key", JTypeReferenceBuilder.create(JClassReference.create(String.class))).withFinal(true),
                        JParameterBuilder.create("value", JGenericReferenceBuilder.create(myListClassStaticMethodGeneric)).withFinal(true)
                )
                .withThrow(JClassReferenceBuilder.create(JClassReference.create(IllegalArgumentException.class)))
                .withBody(JMethodBodyBuilder.create());
        final JClassDescriptor myListClass = JClassBuilder.create("MyList").withAbstract(true)
                .withGeneric(myListGeneric)
                .withSuperClass(myListSuperClass)
                .withInterface(JInterfaceReferenceBuilder.create(JInterfaceReference.create(Serializable.class)))
                .withMethods(
                        myListClassStaticMethod,
                        JStandardMethodBuilder.create("getKey", JTypeReferenceBuilder.create(JClassReference.create(String.class)))
                                .withBody(JMethodBodyBuilder.create()),
                        JStandardMethodBuilder.create("getValue", JGenericReferenceBuilder.create(myListGeneric))
                                .withBody(JMethodBodyBuilder.create()),
                        JStandardMethodBuilder.create(JVisibility.Protected, "validate", (JTypeReferenceDescriptor) null)
                )
                .withFields(
                        JFieldBuilder.create("DEFAULT", JTypeReferenceBuilder.create(JClassReference.create(int.class)))
                                .withFinal(true).withStatic(true).withValue(JSimpleValueBuilder.create(99, JNumberType.Integer)),
                        JFieldBuilder.create("UNKNOWN", JTypeReferenceBuilder.create(JClassReference.create(Integer.class)))
                                .withFinal(true).withStatic(true).withValue(JPrimitiveValueBuilder.create(101, JNumberType.Integer)
                                .withUsePrimitive(false)),
                        JFieldBuilder.create("key", JTypeReferenceBuilder.create(JClassReference.create(String.class))),
                        JFieldBuilder.create("value", JGenericReferenceBuilder.create(myListGeneric))
                )
                .build();

        final JFileDescriptor fileDescriptor = JFileBuilder.create("MyList")
                .withPackage("org.pcsoft.framework.jcoding.test")
                .withJavaType(myListClass)
                .build();

        final String javaCode = JCoding.generateCode(fileDescriptor, JCodingProcessorFactory.getInstance());
        System.out.println(javaCode);
    }

}
