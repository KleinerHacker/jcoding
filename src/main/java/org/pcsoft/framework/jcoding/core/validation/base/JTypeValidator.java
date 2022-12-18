package org.pcsoft.framework.jcoding.core.validation.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public abstract class JTypeValidator<T extends JTypeData> extends JMemberValidator<T> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    @Override
    protected void validateName(T data) {
        log.debug("Validate type " + data.getName());
        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("The name '" + data.getName() + "' is not allowed for type");
    }
}
