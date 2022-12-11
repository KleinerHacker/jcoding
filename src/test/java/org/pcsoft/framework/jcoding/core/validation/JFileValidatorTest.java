package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JFileBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JFileValidatorTest {

    @Test
    public void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                new JFileValidator().validate(
                        new JFileBuilder("Test.java")
                                .build()
                )
        );
    }

    @Test
    public void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JFileValidator().validate(
                        new JFileBuilder("123.java")
                                .build()
                )
        );
    }

}