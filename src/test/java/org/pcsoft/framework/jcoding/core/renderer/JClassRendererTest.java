package org.pcsoft.framework.jcoding.core.renderer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JClassBuilder;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

import java.io.Serializable;
import java.util.List;

class JClassRendererTest {

    @Test
    void testSimple() {
        final var renderer = JClassRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JClassBuilder("MyClass")
                        .build()
        );

        Assertions.assertEquals(
                "public class MyClass {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testAbstract() {
        final var renderer = JClassRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JClassBuilder("MyClass")
                        .hasAccess(JAccessModifier.PACKAGE_INTERNAL)
                        .isAbstract()
                        .build()
        );

        Assertions.assertEquals(
                "abstract class MyClass {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testFinal() {
        final var renderer = JClassRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JClassBuilder("MyClass")
                        .hasAccess(JAccessModifier.PACKAGE_INTERNAL)
                        .isFinal()
                        .build()
        );

        Assertions.assertEquals(
                "final class MyClass {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testStatic() {
        final var renderer = JClassRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JClassBuilder("MyClass")
                        .hasAccess(JAccessModifier.PROTECTED)
                        .isStatic()
                        .build()
        );

        Assertions.assertEquals(
                "protected static class MyClass {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testExtends() {
        final var renderer = JClassRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JClassBuilder("MyClass")
                        .useSuperType("Demo", x -> x.inPackage("org.pcsoft"))
                        .build()
        );

        Assertions.assertEquals(
                "public class MyClass extends org.pcsoft.Demo {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testImplements() {
        final var renderer = JClassRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JClassBuilder("MyClass")
                        .useInterface(List.class)
                        .useInterface(Serializable.class)
                        .build()
        );

        Assertions.assertEquals(
                "public class MyClass implements java.util.List, java.io.Serializable {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testExtendsAndImplements() {
        final var renderer = JClassRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JClassBuilder("MyClass")
                        .useSuperType("Demo", x -> x.inPackage("org.pcsoft"))
                        .useInterface(List.class)
                        .useInterface(Serializable.class)
                        .build()
        );

        Assertions.assertEquals(
                "public class MyClass extends org.pcsoft.Demo implements java.util.List, java.io.Serializable {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

    @Test
    void testWithContent() {
        final var renderer = JClassRenderer.getInstance();
        final var code = renderer.renderToString(0,
                new JClassBuilder("MyClass")
                        .withField("myField", x -> x.typeOf(int.class).hasAccess(JAccessModifier.PRIVATE))
                        .withMethod("doAny", x -> x.withParameter("value", y -> y.ofType(double.class).isFinal()))
                        .withClass("MySubClass", x -> x)
                        .withInterface("MySubInterface", x -> x)
                        .withEnumeration("MySubEnum", x -> x)
                        .build()
        );

        Assertions.assertEquals(
                "public class MyClass {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "  private int myField;" + System.lineSeparator()
                        + System.lineSeparator()
                        + "  public void doAny(final double value) {" + System.lineSeparator()
                        + "  }" + System.lineSeparator()
                        + System.lineSeparator()
                        + "  public class MySubClass {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "  }" + System.lineSeparator()
                        + System.lineSeparator()
                        + "  public interface MySubInterface {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "  }" + System.lineSeparator()
                        + System.lineSeparator()
                        + "  public enum MySubEnum {" + System.lineSeparator()
                        + System.lineSeparator()
                        + "  }" + System.lineSeparator()
                        + System.lineSeparator()
                        + "}",
                code
        );
    }

}