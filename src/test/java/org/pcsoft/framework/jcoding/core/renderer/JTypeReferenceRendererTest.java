package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceBuilder;

class JTypeReferenceRendererTest {

    @Test
    void testSimple() {
        final var renderer = JTypeReferenceRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JTypeReferenceBuilder("String")
                        .inPackage("java.lang")
                        .build()
        );

        Assertions.assertEquals("java.lang.String", code);
    }

    @Test
    void testNoPackage() {
        final var renderer = JTypeReferenceRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JTypeReferenceBuilder("int")
                        .build()
        );

        Assertions.assertEquals("int", code);
    }

    @Test
    void testGenerics() {
        final var renderer = JTypeReferenceRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JTypeReferenceBuilder("Map")
                        .inPackage("java.lang")
                        .withGeneric(String.class)
                        .withGeneric(Integer.class)
                        .build()
        );

        Assertions.assertEquals("java.lang.Map<java.lang.String, java.lang.Integer>", code);
    }

}