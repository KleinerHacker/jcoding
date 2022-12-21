package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JMethodBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JMethodValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JMethodValidator.getInstance().validateContent(
                        new JMethodBuilder("doAny")
                                .build()
                )
        );
    }

    @Test
    void testSuccessWithType() {
        Assertions.assertDoesNotThrow(() ->
                JMethodValidator.getInstance().validateContent(
                        new JMethodBuilder("doAny")
                                .withReturnType(String.class)
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JMethodValidator.getInstance().validateContent(
                        new JMethodBuilder("123")
                                .build()
                )
        );
    }

    @Test
    void testStaticWithAbstract() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JMethodValidator.getInstance().validateContent(
                        new JMethodBuilder("doAny")
                                .isAbstract()
                                .isStatic()
                                .build()
                )
        );
    }

    @Test
    void testStaticWithFinal() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JMethodValidator.getInstance().validateContent(
                        new JMethodBuilder("doAny")
                                .isFinal()
                                .isStatic()
                                .build()
                )
        );
    }

    @Test
    void testAbstractAndFinal() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JMethodValidator.getInstance().validateContent(
                        new JMethodBuilder("doAny")
                                .isAbstract()
                                .isFinal()
                                .build()
                )
        );
    }

}