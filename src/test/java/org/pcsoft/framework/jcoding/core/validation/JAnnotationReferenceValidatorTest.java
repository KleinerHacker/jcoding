package org.pcsoft.framework.jcoding.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceBuilder;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

class JAnnotationReferenceValidatorTest {

    @Test
    void testSuccess() {
        Assertions.assertDoesNotThrow(() ->
                JAnnotationReferenceValidator.getInstance().validate(
                        new JAnnotationReferenceBuilder()
                                .ofType(Test.class)
                                .withParameter("param", p -> p.withValue(10))
                                .build()
                )
        );
    }

    @Test
    void testInvalidType() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JAnnotationReferenceValidator.getInstance().validate(
                        new JAnnotationReferenceBuilder()
                                .ofType("123", x -> x.inPackage("org.pcsoft"))
                                .withParameter("param", p -> p.withValue(10))
                                .build()
                )
        );
    }

    @Test
    void testNoType() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JAnnotationReferenceValidator.getInstance().validate(
                        new JAnnotationReferenceBuilder()
                                .withParameter("param", p -> p.withValue(10))
                                .build()
                )
        );
    }

    @Test
    void testInvalidPackage() {
        Assertions.assertThrows(JCodingValidationException.class, () ->
                JAnnotationReferenceValidator.getInstance().validate(
                        new JAnnotationReferenceBuilder()
                                .ofType("Test", x -> x.inPackage("123.pcsoft"))
                                .withParameter("param", p -> p.withValue(10))
                                .build()
                )
        );
    }

}