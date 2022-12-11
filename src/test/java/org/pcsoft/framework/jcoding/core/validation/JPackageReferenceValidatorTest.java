package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JPackageReferenceBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JPackageReferenceValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                new JPackageReferenceValidator().validate(
                        new JPackageReferenceBuilder("org.pcsoft")
                                .build()
                )
        );
    }

    @Test
    void testSuccessOne() {
        Assertions.assertDoesNotThrow(() ->
                new JPackageReferenceValidator().validate(
                        new JPackageReferenceBuilder("org")
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JPackageReferenceValidator().validate(
                        new JPackageReferenceBuilder("org.123")
                                .build()
                )
        );
    }

    @Test
    void testInvalidNameOne() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JPackageReferenceValidator().validate(
                        new JPackageReferenceBuilder("123")
                                .build()
                )
        );
    }

}