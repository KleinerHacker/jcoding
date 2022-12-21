package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JPackageBuilder;

class JPackageRendererTest {

    @Test
    void testSimple() {
        final var code = JPackageRenderer.getInstance().renderToString(0,
                new JPackageBuilder("org.pcsoft.framework.jcoding")
                        .build()
        );

        Assertions.assertEquals("package org.pcsoft.framework.jcoding;", code);
    }

    @Test
    void testWithAnnotation() {
        final var code = JPackageRenderer.getInstance().renderToString(0,
                new JPackageBuilder("org.pcsoft.framework.jcoding")
                        .withAnnotation(x -> x.ofType(Test.class))
                        .build()
        );

        Assertions.assertEquals(
                "@org.junit.jupiter.api.Test()" + System.lineSeparator()
                        + "package org.pcsoft.framework.jcoding;",
                code
        );
    }

}