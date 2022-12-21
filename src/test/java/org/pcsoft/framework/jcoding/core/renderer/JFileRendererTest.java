package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JFileBuilder;

class JFileRendererTest {

    @Test
    void testSimpleClass() {
        final var renderer = JFileRenderer.getInstance();
        final var code = renderer.renderToString(0,
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
                        + System.lineSeparator()
                        + "@org.junit.jupiter.api.Test(demo = 10)" + System.lineSeparator()
                        + "public abstract class MyClass {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testSimpleInterface() {
        final var renderer = JFileRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JFileBuilder("MyInterface.java")
                        .inPackage("org.pcsoft.test")
                        .withInterface("MyInterface", c -> c
                                .withAnnotation(a -> a
                                        .ofType(Test.class)
                                        .withParameter("demo", p -> p.withValue(10))
                                )
                        )
                        .build()
        );

        Assertions.assertEquals(
                "package org.pcsoft.test;" + System.lineSeparator()
                        + System.lineSeparator()
                        + "@org.junit.jupiter.api.Test(demo = 10)" + System.lineSeparator()
                        + "public interface MyInterface {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testSimpleEnumeration() {
        final var renderer = JFileRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JFileBuilder("MyEnum.java")
                        .inPackage("org.pcsoft.test")
                        .withEnumeration("MyEnum", c -> c
                                .withAnnotation(a -> a
                                        .ofType(Test.class)
                                        .withParameter("demo", p -> p.withValue(10))
                                )
                        )
                        .build()
        );

        Assertions.assertEquals(
                "package org.pcsoft.test;" + System.lineSeparator()
                        + System.lineSeparator()
                        + "@org.junit.jupiter.api.Test(demo = 10)" + System.lineSeparator()
                        + "public enum MyEnum {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

}