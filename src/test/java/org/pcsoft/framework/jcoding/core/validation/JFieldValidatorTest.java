package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JFieldBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JFieldValidatorTest {

    @Test
    void testSimpleSuccess() {
        Assertions.assertDoesNotThrow(() ->
                new JFieldValidator().validate(
                        new JFieldBuilder("test")
                                .typeOf(int.class)
                                .build()
                )
        );
    }

    @Test
    void testStaticFinalSuccess() {
        Assertions.assertDoesNotThrow(() ->
                new JFieldValidator().validate(
                        new JFieldBuilder("test")
                                .typeOf(int.class)
                                .isStatic()
                                .isFinal()
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JFieldValidator().validate(
                        new JFieldBuilder("123")
                                .typeOf(int.class)
                                .build()
                )
        );
    }

    @Test
    void testInvalidType() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JFieldValidator().validate(
                        new JFieldBuilder("test")
                                .typeOf("123", x -> x.inPackage("org.pcsoft"))
                                .build()
                )
        );
    }

    @Test
    void testNoType() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JFieldValidator().validate(
                        new JFieldBuilder("test")
                                .build()
                )
        );
    }

}