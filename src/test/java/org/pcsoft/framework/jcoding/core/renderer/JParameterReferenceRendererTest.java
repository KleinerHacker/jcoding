package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JParameterReferenceBuilder;

import java.net.Proxy;

class JParameterReferenceRendererTest {

    @Test
    void testInteger() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("number")
                        .withValue(10)
                        .build()
        );

        Assertions.assertEquals("number = 10", code);
    }

    @Test
    void testLong() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("number")
                        .withValue(10L)
                        .build()
        );

        Assertions.assertEquals("number = 10L", code);
    }

    @Test
    void testDouble() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("number")
                        .withValue(1.1d)
                        .build()
        );

        Assertions.assertEquals("number = 1.1d", code);
    }

    @Test
    void testFloat() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("number")
                        .withValue(1.1f)
                        .build()
        );

        Assertions.assertEquals("number = 1.1f", code);
    }

    @Test
    void testString() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("text")
                        .withValue("demo")
                        .build()
        );

        Assertions.assertEquals("text = \"demo\"", code);
    }

    @Test
    void testCharacter() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("text")
                        .withValue('c')
                        .build()
        );

        Assertions.assertEquals("text = 'c'", code);
    }

    @Test
    void testBoolean() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("active")
                        .withValue(true)
                        .build()
        );

        Assertions.assertEquals("active = true", code);
    }

    @Test
    void testClass() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("clazz")
                        .withValue(String.class)
                        .build()
        );

        Assertions.assertEquals("clazz = java.lang.String.class", code);
    }

    @Test
    void testEnum() {
        final var renderer = JParameterReferenceRenderer.getInstance();
        final var code = renderer.renderToString(
                new JParameterReferenceBuilder("select")
                        .withValue(Proxy.Type.HTTP)
                        .build()
        );

        Assertions.assertEquals("select = java.net.Proxy.Type.HTTP", code);
    }
}