package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JPackageBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JPackageValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JPackageValidator.getInstance().validate(
                        new JPackageBuilder("org.pcsoft")
                                .build()
                )
        );
    }

    @Test
    void testSuccessOne() {
        Assertions.assertDoesNotThrow(() ->
                JPackageValidator.getInstance().validate(
                        new JPackageBuilder("org")
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JPackageValidator.getInstance().validate(
                        new JPackageBuilder("org.123")
                                .build()
                )
        );
    }

    @Test
    void testInvalidNameOne() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JPackageValidator.getInstance().validate(
                        new JPackageBuilder("123")
                                .build()
                )
        );
    }

}