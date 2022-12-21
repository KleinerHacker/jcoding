package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JEnumerationBuilder;

class JEnumerationRendererTest {

    @Test
    void testSimple() {
        final var renderer = JEnumerationRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JEnumerationBuilder("MyEnum")
                        .build()
        );

        Assertions.assertEquals(
                "public enum MyEnum {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

}