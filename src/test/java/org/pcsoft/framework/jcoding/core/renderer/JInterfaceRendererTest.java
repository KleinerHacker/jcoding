package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JInterfaceBuilder;

import java.io.Serializable;
import java.util.List;

class JInterfaceRendererTest {

    @Test
    void testSimple() {
        final var renderer = JInterfaceRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JInterfaceBuilder("MyInterface")
                        .build()
        );

        Assertions.assertEquals(
                "public interface MyInterface {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testExtends() {
        final var renderer = JInterfaceRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JInterfaceBuilder("MyInterface")
                        .useInterface(List.class)
                        .useInterface(Serializable.class)
                        .build()
        );

        Assertions.assertEquals(
                "public interface MyInterface extends java.util.List, java.io.Serializable {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

}