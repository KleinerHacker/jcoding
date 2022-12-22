package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JGenericBuilder;

class JGenericRendererTest {

    @Test
    void testSimple() {
        final var renderer = JGenericRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JGenericBuilder("T")
                        .build()
        );

        Assertions.assertEquals("T", code);
    }

    @Test
    void testExtends() {
        final var renderer = JGenericRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JGenericBuilder("T")
                        .extendsFrom(String.class)
                        .build()
        );

        Assertions.assertEquals("T extends java.lang.String", code);
    }

    @Test
    void testSuper() {
        final var renderer = JGenericRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JGenericBuilder("T")
                        .superFrom(String.class)
                        .build()
        );

        Assertions.assertEquals("T super java.lang.String", code);
    }

}