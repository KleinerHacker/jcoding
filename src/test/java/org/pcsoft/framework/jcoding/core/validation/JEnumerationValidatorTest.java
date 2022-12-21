package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JEnumerationBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JEnumerationValidatorTest {

    @Test
    void testSuccessSimple() {
        Assertions.assertDoesNotThrow(() ->
                JEnumerationValidator.getInstance().validateContent(
                        new JEnumerationBuilder("MyEnum")
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JEnumerationValidator.getInstance().validateContent(
                        new JEnumerationBuilder("123")
                                .build()
                )
        );
    }

    @Test
    void testInvalidModifier() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JEnumerationValidator.getInstance().validateContent(
                        new JEnumerationBuilder("123")
                                .hasAccess(null)
                                .build()
                )
        );
    }

}