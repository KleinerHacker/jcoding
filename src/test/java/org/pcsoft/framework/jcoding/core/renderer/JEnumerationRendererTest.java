package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JEnumerationBuilder;

import java.io.Serializable;
import java.util.List;

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

    @Test
    void testImplements() {
        final var renderer = JEnumerationRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JEnumerationBuilder("MyEnum")
                        .useInterface(List.class)
                        .useInterface(Serializable.class)
                        .build()
        );

        Assertions.assertEquals(
                "public enum MyEnum implements java.util.List, java.io.Serializable {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

}