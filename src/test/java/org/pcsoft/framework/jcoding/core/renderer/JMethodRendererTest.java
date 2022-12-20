package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JMethodBuilder;

class JMethodRendererTest {

    @Test
    void testSimple() {
        final var renderer = new JMethodRenderer();
        final var code = renderer.renderToString(
                new JMethodBuilder("doAny")
                        .build()
        );

        Assertions.assertEquals("public void doAny() {" + System.lineSeparator() + "}", code);
    }

    @Test
    void testStatic() {
        final var renderer = new JMethodRenderer();
        final var code = renderer.renderToString(
                new JMethodBuilder("doAny")
                        .isStatic()
                        .build()
        );

        Assertions.assertEquals("public static void doAny() {" + System.lineSeparator() + "}", code);
    }

    @Test
    void testAbstract() {
        final var renderer = new JMethodRenderer();
        final var code = renderer.renderToString(
                new JMethodBuilder("doAny")
                        .isAbstract()
                        .build()
        );

        Assertions.assertEquals("public abstract void doAny();", code);
    }

    @Test
    void testFinal() {
        final var renderer = new JMethodRenderer();
        final var code = renderer.renderToString(
                new JMethodBuilder("doAny")
                        .isFinal()
                        .build()
        );

        Assertions.assertEquals("public final void doAny() {" + System.lineSeparator() + "}", code);
    }

    @Test
    void testType() {
        final var renderer = new JMethodRenderer();
        final var code = renderer.renderToString(
                new JMethodBuilder("doAny")
                        .withReturnType(String.class)
                        .build()
        );

        Assertions.assertEquals("public java.lang.String doAny() {" + System.lineSeparator() + "}", code);
    }

}