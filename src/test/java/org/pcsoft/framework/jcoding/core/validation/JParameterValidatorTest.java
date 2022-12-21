package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JParameterBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JParameterValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                new JParameterValidator().validate(
                        new JParameterBuilder("param")
                                .ofType(String.class)
                                .build()
                )
        );
    }

    @Test
    void testFinal() {
        Assertions.assertDoesNotThrow(() ->
                new JParameterValidator().validate(
                        new JParameterBuilder("param")
                                .ofType(String.class)
                                .isFinal()
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JParameterValidator().validate(
                        new JParameterBuilder("123")
                                .ofType(String.class)
                                .build()
                )
        );
    }

    @Test
    void testNoType() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JParameterValidator().validate(
                        new JParameterBuilder("param")
                                .build()
                )
        );
    }

    @Test
    void testWrongType() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JParameterValidator().validate(
                        new JParameterBuilder("param")
                                .ofType("123", x -> x)
                                .build()
                )
        );
    }

}