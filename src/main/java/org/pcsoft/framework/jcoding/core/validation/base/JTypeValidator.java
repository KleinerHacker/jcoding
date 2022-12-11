package org.pcsoft.framework.jcoding.core.validation.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public abstract class JTypeValidator<T extends JTypeData> extends JAnnotatableValidator<T> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    @Override
    protected void validateContent(T data) {
        log.debug("Validate type " + data.getName());
        if (data.getAccess() == null)
            throw new JCodingValidationException("The type accessor is null for " + data.getName());
        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("The name '" + data.getName() + "' is not allowed for type");
    }

}
