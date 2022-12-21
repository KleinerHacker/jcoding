package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JParameterBuilder;

class JParameterRendererTest {

    @Test
    void testSimple() {
        final var renderer = JParameterRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JParameterBuilder("param")
                        .ofType(String.class)
                        .build()
        );

        Assertions.assertEquals("java.lang.String param", code);
    }

    @Test
    void testFinal() {
        final var renderer = JParameterRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JParameterBuilder("param")
                        .ofType("Demo", x -> x.inPackage("org.pcsoft"))
                        .isFinal()
                        .build()
        );

        Assertions.assertEquals("final org.pcsoft.Demo param", code);
    }

}