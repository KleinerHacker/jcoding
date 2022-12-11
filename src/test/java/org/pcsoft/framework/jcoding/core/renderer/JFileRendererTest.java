package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JFileBuilder;

class JFileRendererTest {

    @Test
    void testSimpleClass() {
        final var renderer = new JFileRenderer();
        final var code = renderer.renderToString(
                new JFileBuilder("MyClass.java")
                        .inPackage("org.pcsoft.test")
                        .withClass("MyClass", c -> c
                                .isAbstract()
                                .withAnnotation(a -> a
                                        .ofType(Test.class)
                                        .withParameter("demo", p -> p.withValue(10))
                                )
                        )
                        .build()
        );

        Assertions.assertEquals(
                "package org.pcsoft.test;" + System.lineSeparator()
                        + "@org.junit.jupiter.api.Test(demo = 10)" + System.lineSeparator()
                        + "public abstract class MyClass {" + System.lineSeparator()
                        + "}",
                code
        );
    }

}