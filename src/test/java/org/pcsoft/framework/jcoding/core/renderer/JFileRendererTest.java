package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JFileBuilder;

class JFileRendererTest {

    @Test
    void test() {
        final var renderer = new JFileRenderer();
        final var code = renderer.renderToString(
                new JFileBuilder()
                        .inPackage("org.pcsoft.test")
                        .build()
        );

        Assertions.assertEquals("\npackage org.pcsoft.test;", code);
    }

}