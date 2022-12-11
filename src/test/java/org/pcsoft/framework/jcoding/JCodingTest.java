package org.pcsoft.framework.jcoding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JCodingTest {

    @Test
    void testSimpleClass() {
        final var file = JCoding.createFile("MyClass.java")
                .inPackage("org.pcsoft.test")
                .withClass("MyClass", c -> c
                        .isAbstract()
                        .withAnnotation(a -> a
                                .ofType(Test.class)
                                .withParameter("demo", p -> p.withValue(10))
                        )
                )
                .build();
        final var code = JCoding.renderFileToString(file);

        Assertions.assertEquals(
                "package org.pcsoft.test;" + System.lineSeparator()
                        + "@org.junit.jupiter.api.Test(demo = 10)" + System.lineSeparator()
                        + "public abstract class MyClass {" + System.lineSeparator()
                        + "}",
                code
        );
    }

}