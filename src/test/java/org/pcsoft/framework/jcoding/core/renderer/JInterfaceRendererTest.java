package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JInterfaceBuilder;

class JInterfaceRendererTest {

    @Test
    void testSimple() {
        final var renderer = new JInterfaceRenderer();
        final var code = renderer.renderToString(
                new JInterfaceBuilder("MyInterface")
                        .build()
        );

        Assertions.assertEquals(
                "public interface MyInterface {" + System.lineSeparator()
                        + "}",
                code
        );
    }

}