package org.pcsoft.framework.jcoding;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JFileData;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

class JCodingTest {

    private static JFileData fileData;

    @BeforeAll
    static void init() {
        fileData = JCoding.createFile("MyClass.java")
                .inPackage("org.pcsoft.test")
                .withClass("MyClass", c -> c
                        .isAbstract()
                        .withAnnotation(a -> a
                                .ofType(Test.class)
                                .withParameter("demo", p -> p.withValue(10))
                        )
                )
                .build();
    }

    @Test
    void testToString() {
        final var code = JCoding.renderFileToString(fileData);
        assetCode(code);
    }

    @Test
    void testToStream() {
        Assertions.assertDoesNotThrow(() -> {
            try (final var out = new ByteArrayOutputStream()) {
                JCoding.renderFile(fileData, out);
                assetCode(out.toString(StandardCharsets.UTF_8));
            }
        });
    }

    @Test
    void testToWriter() {
        Assertions.assertDoesNotThrow(() -> {
            try (final var out = new StringWriter()) {
                JCoding.renderFile(fileData, out);
                assetCode(out.toString());
            }
        });
    }

    @Test
    void testToFile() {
        Assertions.assertDoesNotThrow(() -> {
            final var tempFile = File.createTempFile("test_", ".java");
            try {
                JCoding.renderFile(fileData, tempFile);
                assetCode(FileUtils.readFileToString(tempFile, StandardCharsets.UTF_8));
            } finally {
                FileUtils.delete(tempFile);
            }
        });
    }

    private void assetCode(String code) {
        Assertions.assertEquals(
                "package org.pcsoft.test;" + System.lineSeparator()
                        + "@org.junit.jupiter.api.Test(demo = 10)" + System.lineSeparator()
                        + "public abstract class MyClass {" + System.lineSeparator()
                        + "}",
                code
        );
    }

}