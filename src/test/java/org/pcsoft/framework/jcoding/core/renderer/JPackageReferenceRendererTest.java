package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JPackageReferenceBuilder;

class JPackageReferenceRendererTest {

    @Test
    void test() {
        final var renderer = new JPackageReferenceRenderer();
        final var code = renderer.renderToString(
                new JPackageReferenceBuilder("org.pcsoft.framework.jcoding")
                        .build()
        );

        Assertions.assertEquals("org.pcsoft.framework.jcoding", code);
    }

}