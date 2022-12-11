package org.pcsoft.framework.jcoding.core.validation.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JAnnotatableData;
import org.pcsoft.framework.jcoding.core.validation.JAnnotationReferenceValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public abstract class JAnnotatableValidator<T extends JAnnotatableData> extends JNamedValidator<T> {
    private final JAnnotationReferenceValidator annotationReferenceValidator = new JAnnotationReferenceValidator();

    @Override
    public final void validate(T data) {
        log.debug("Validate annotatable object " + data.getName());
        try {
            data.getAnnotationReferences()
                    .forEach(annotationReferenceValidator::validate);
        } catch (JCodingValidationException e) {
            throw new JCodingValidationException("Validation failed for annotatable object " + data.getName(), e);
        }
        validateContent(data);
    }

    protected abstract void validateContent(T data);
}
