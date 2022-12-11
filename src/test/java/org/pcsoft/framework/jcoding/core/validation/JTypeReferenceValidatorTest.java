package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JTypeReferenceValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                new JTypeReferenceValidator().validate(
                        new JTypeReferenceBuilder("Test")
                                .inPackage("org.pcsoft")
                                .build()
                )
        );
    }

    @Test
    void testSuccessNoPackage() {
        Assertions.assertDoesNotThrow(() ->
                new JTypeReferenceValidator().validate(
                        new JTypeReferenceBuilder("Test")
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JTypeReferenceValidator().validate(
                        new JTypeReferenceBuilder("123")
                                .inPackage("org.pcsoft")
                                .build()
                )
        );
    }

    @Test
    void testInvalidPackage() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JTypeReferenceValidator().validate(
                        new JTypeReferenceBuilder("Test")
                                .inPackage("org.123")
                                .build()
                )
        );
    }

}