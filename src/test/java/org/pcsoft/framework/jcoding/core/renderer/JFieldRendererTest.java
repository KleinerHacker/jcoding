package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JFieldBuilder;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

class JFieldRendererTest {

    @Test
    void testSimple() {
        final var renderer = new JFieldRenderer();
        final var code = renderer.renderToString(
                new JFieldBuilder("test")
                        .typeOf(String.class)
                        .build()
        );

        Assertions.assertEquals("public java.lang.String test", code);
    }

    @Test
    void testStatic() {
        final var renderer = new JFieldRenderer();
        final var code = renderer.renderToString(
                new JFieldBuilder("test")
                        .typeOf("Test", x -> x.inPackage("org.pcsoft"))
                        .hasAccess(JAccessModifier.PRIVATE)
                        .isStatic()
                        .build()
        );

        Assertions.assertEquals("private static org.pcsoft.Test test", code);
    }

    @Test
    void testFinal() {
        final var renderer = new JFieldRenderer();
        final var code = renderer.renderToString(
                new JFieldBuilder("test")
                        .typeOf(String.class)
                        .isFinal()
                        .build()
        );

        Assertions.assertEquals("public final java.lang.String test", code);
    }

    @Test
    void testStaticFinal() {
        final var renderer = new JFieldRenderer();
        final var code = renderer.renderToString(
                new JFieldBuilder("test")
                        .typeOf(String.class)
                        .isStatic()
                        .isFinal()
                        .build()
        );

        Assertions.assertEquals("public static final java.lang.String test", code);
    }

    @Test
    void testConstant() {
        final var renderer = new JFieldRenderer();
        final var code = renderer.renderToString(
                new JFieldBuilder("test")
                        .typeOf(String.class)
                        .isStatic()
                        .isFinal()
                        .withValue(10)
                        .build()
        );

        Assertions.assertEquals("public static final java.lang.String test = 10", code);
    }

}