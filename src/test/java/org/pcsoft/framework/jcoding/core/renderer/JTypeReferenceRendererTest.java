package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceBuilder;

class JTypeReferenceRendererTest {

    @Test
    void testSimple() {
        final var renderer = new JTypeReferenceRenderer();
        final var code = renderer.renderToString(
                new JTypeReferenceBuilder("String")
                        .inPackage("java.lang")
                        .build()
        );

        Assertions.assertEquals("java.lang.String", code);
    }

    @Test
    void testNoPackage() {
        final var renderer = new JTypeReferenceRenderer();
        final var code = renderer.renderToString(
                new JTypeReferenceBuilder("int")
                        .build()
        );

        Assertions.assertEquals("int", code);
    }

}