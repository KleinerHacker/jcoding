package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JClassBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JClassValidatorTest {

    @Test
    void testSimpleSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JClassValidator.getInstance().validateContent(
                        new JClassBuilder("Test")
                                .build()
                )
        );
    }

    @Test
    void testStaticSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JClassValidator.getInstance().validateContent(
                        new JClassBuilder("Test")
                                .isStatic()
                                .build()
                )
        );
    }

    @Test
    void testAbstractSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JClassValidator.getInstance().validateContent(
                        new JClassBuilder("Test")
                                .isAbstract()
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JClassValidator.getInstance().validateContent(
                        new JClassBuilder("123")
                                .build()
                )
        );
    }

    @Test
    void testInvalidAccessModifier() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JClassValidator.getInstance().validateContent(
                        new JClassBuilder("Test")
                                .hasAccess(null)
                                .build()
                )
        );
    }

    @Test
    void testStaticAbstractSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JClassValidator.getInstance().validateContent(
                        new JClassBuilder("Test")
                                .isStatic()
                                .isAbstract()
                                .build()
                )
        );
    }

    @Test
    void testStaticFinalSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JClassValidator.getInstance().validateContent(
                        new JClassBuilder("Test")
                                .isStatic()
                                .isFinal()
                                .build()
                )
        );
    }

    @Test
    void testInvalidModifierAbstractFinal() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JClassValidator.getInstance().validateContent(
                        new JClassBuilder("Test")
                                .isFinal()
                                .isAbstract()
                                .build()
                )
        );
    }

}