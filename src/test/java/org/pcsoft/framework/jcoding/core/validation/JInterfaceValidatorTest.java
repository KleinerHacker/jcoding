package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JInterfaceBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JInterfaceValidatorTest {

    @Test
    void testSuccessSimple() {
        Assertions.assertDoesNotThrow(() ->
                new JInterfaceValidator().validateContent(
                        new JInterfaceBuilder("MyInterface")
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JInterfaceValidator().validateContent(
                        new JInterfaceBuilder("123")
                                .build()
                )
        );
    }

    @Test
    void testInvalidModifier() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                new JInterfaceValidator().validateContent(
                        new JInterfaceBuilder("123")
                                .hasAccess(null)
                                .build()
                )
        );
    }

}