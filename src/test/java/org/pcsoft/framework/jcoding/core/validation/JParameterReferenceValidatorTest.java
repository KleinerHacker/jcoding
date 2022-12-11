package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JParameterReferenceBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JParameterReferenceValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                new JParameterReferenceValidator().validate(
                        new JParameterReferenceBuilder("name")
                                .withValue(10)
                                .build()
                )
        );
    }

    @Test
    void testSuccessNull() {
        Assertions.assertDoesNotThrow(() ->
                new JParameterReferenceValidator().validate(
                        new JParameterReferenceBuilder("name")
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JParameterReferenceValidator().validate(
                        new JParameterReferenceBuilder("123")
                                .withValue(10)
                                .build()
                )
        );
    }

}