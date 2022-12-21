package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceBuilder;

class JAnnotationReferenceRenderTest {

    @Test
    void testSimple() {
        final var renderer = JAnnotationReferenceRender.getInstance();
        final var code = renderer.renderToString(
                new JAnnotationReferenceBuilder()
                        .ofType(Test.class)
                        .build()
        );

        Assertions.assertEquals("@org.junit.jupiter.api.Test()", code);
    }

    @Test
    void testWithSingleParameter() {
        final var renderer = JAnnotationReferenceRender.getInstance();
        final var code = renderer.renderToString(
                new JAnnotationReferenceBuilder()
                        .ofType("MyAnnotation", x -> x.inPackage("org.pcsoft"))
                        .withParameter("any", x -> x.withValue(10))
                        .build()
        );

        Assertions.assertEquals("@org.pcsoft.MyAnnotation(any = 10)", code);
    }

    @Test
    void testWithMultipleParameter() {
        final var renderer = JAnnotationReferenceRender.getInstance();
        final var code = renderer.renderToString(
                new JAnnotationReferenceBuilder()
                        .ofType("MyAnnotation", x -> x.inPackage("org.pcsoft"))
                        .withParameter("any", x -> x.withValue(10))
                        .withParameter("other", x -> x.withValue(true))
                        .build()
        );

        Assertions.assertEquals("@org.pcsoft.MyAnnotation(any = 10, other = true)", code);
    }

}