package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JParameterReferenceData;
import org.pcsoft.framework.jcoding.core.validation.base.JNamedValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JParameterReferenceValidator extends JNamedValidator<JParameterReferenceData> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    @Override
    public void validate(JParameterReferenceData data) {
        log.debug("Validate parameter reference " + data.getName());
        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("Parameter reference with name '" + data.getName() + "' is not allowed");
    }
}
