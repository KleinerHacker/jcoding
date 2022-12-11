package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JPackageBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JPackageValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                new JPackageValidator().validate(
                        new JPackageBuilder("org.pcsoft")
                                .build()
                )
        );
    }

    @Test
    void testSuccessOne() {
        Assertions.assertDoesNotThrow(() ->
                new JPackageValidator().validate(
                        new JPackageBuilder("org")
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JPackageValidator().validate(
                        new JPackageBuilder("org.123")
                                .build()
                )
        );
    }

    @Test
    void testInvalidNameOne() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JPackageValidator().validate(
                        new JPackageBuilder("123")
                                .build()
                )
        );
    }

}