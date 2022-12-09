package org.pcsoft.framework.jcoding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JCodingTest {

    @Test
    void test() {
        final var file = JCoding.createFile("MyClass.java")
                .inPackage("org.pcsoft.demo")
                .build();
        final var code = JCoding.renderFileToString(file);

        Assertions.assertEquals("\npackage org.pcsoft.demo;", code);
    }

}