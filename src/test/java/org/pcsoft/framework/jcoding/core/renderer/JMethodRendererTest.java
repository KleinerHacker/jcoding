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

    @Test
    void testCustomType() {
        final var renderer = new JMethodRenderer();
        final var code = renderer.renderToString(
                new JMethodBuilder("doAny")
                        .withReturnType("Demo", x -> x.inPackage("org.pcsoft"))
                        .build()
        );

        Assertions.assertEquals("public org.pcsoft.Demo doAny() {" + System.lineSeparator() + "}", code);
    }

    @Test
    void testSingleParameter() {
        final var renderer = new JMethodRenderer();
        final var code = renderer.renderToString(
                new JMethodBuilder("doAny")
                        .withParameter("param", x -> x.ofType(int.class))
                        .build()
        );

        Assertions.assertEquals("public void doAny(int param) {" + System.lineSeparator() + "}", code);
    }

    @Test
    void testMultipleParameter() {
        final var renderer = new JMethodRenderer();
        final var code = renderer.renderToString(
                new JMethodBuilder("doAny")
                        .withParameter("key", x -> x.ofType(String.class).isFinal())
                        .withParameter("value", x -> x.ofType(int.class).isFinal())
                        .build()
        );

        Assertions.assertEquals("public void doAny(final java.lang.String key, final int value) {" + System.lineSeparator() + "}", code);
    }

}