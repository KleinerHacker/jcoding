package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceData;
import org.pcsoft.framework.jcoding.core.validation.base.JValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JAnnotationReferenceValidator extends JValidator<JAnnotationReferenceData> {
    private final JTypeReferenceValidator typeReferenceValidator = new JTypeReferenceValidator();
    private final JParameterReferenceValidator parameterReferenceValidator = new JParameterReferenceValidator();

    @Override
    public void validate(JAnnotationReferenceData data) {
        log.debug("Validate type reference " + data.getType());

        if (data.getType() == null)
            throw new JCodingValidationException("The type is set to null");

        try {
            typeReferenceValidator.validate(data.getType());
            data.getParameterReferences()
                    .forEach(parameterReferenceValidator::validate);
        } catch (JCodingValidationException e) {
            throw new JCodingValidationException("Validation of annotation reference failed for " + data.getType().getName(), e);
        }
    }
}
