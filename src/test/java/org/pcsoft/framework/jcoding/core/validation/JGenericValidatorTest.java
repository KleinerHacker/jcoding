package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JGenericBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JGenericValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JGenericValidator.getInstance().validate(
                        new JGenericBuilder("T")
                                .build()
                )
        );
    }

    @Test
    void testExtends() {
        Assertions.assertDoesNotThrow(() ->
                JGenericValidator.getInstance().validate(
                        new JGenericBuilder("T")
                                .extendsFrom(String.class)
                                .build()
                )
        );
    }

    @Test
    void testSuper() {
        Assertions.assertDoesNotThrow(() ->
                JGenericValidator.getInstance().validate(
                        new JGenericBuilder("T")
                                .superFrom(String.class)
                                .build()
                )
        );
    }

    @Test
    void testInvalidName() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JGenericValidator.getInstance().validate(
                        new JGenericBuilder("1")
                                .build()
                )
        );
    }

    @Test
    void testInvalidExtends() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JGenericValidator.getInstance().validate(
                        new JGenericBuilder("T")
                                .extendsFrom("123", x -> x.inPackage("org.pcsoft"))
                                .build()
                )
        );
    }

    @Test
    void testInvalidSuper() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JGenericValidator.getInstance().validate(
                        new JGenericBuilder("T")
                                .superFrom("123", x -> x.inPackage("org.pcsoft"))
                                .build()
                )
        );
    }

    @Test
    void testInvalidExtendsAndSuper() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JGenericValidator.getInstance().validate(
                        new JGenericBuilder("T")
                                .extendsFrom(String.class)
                                .superFrom(String.class)
                                .build()
                )
        );
    }

}