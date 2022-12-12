package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JClassBuilder;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

class JClassRendererTest {

    @Test
    void testSimple() {
        final var renderer = new JClassRenderer();
        final var code = renderer.renderToString(
                new JClassBuilder("MyClass")
                        .build()
        );

        Assertions.assertEquals(
                "public class MyClass {" + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testAbstract() {
        final var renderer = new JClassRenderer();
        final var code = renderer.renderToString(
                new JClassBuilder("MyClass")
                        .hasAccess(JAccessModifier.PACKAGE_INTERNAL)
                        .isAbstract()
                        .build()
        );

        Assertions.assertEquals(
                "abstract class MyClass {" + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testFinal() {
        final var renderer = new JClassRenderer();
        final var code = renderer.renderToString(
                new JClassBuilder("MyClass")
                        .hasAccess(JAccessModifier.PACKAGE_INTERNAL)
                        .isFinal()
                        .build()
        );

        Assertions.assertEquals(
                "final class MyClass {" + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testStatic() {
        final var renderer = new JClassRenderer();
        final var code = renderer.renderToString(
                new JClassBuilder("MyClass")
                        .hasAccess(JAccessModifier.PROTECTED)
                        .isStatic()
                        .build()
        );

        Assertions.assertEquals(
                "protected static class MyClass {" + System.lineSeparator()
                        + "}",
                code
        );
    }

}