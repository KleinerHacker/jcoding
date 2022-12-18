package org.pcsoft.framework.jcoding.core.validation.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JMemberData;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public abstract class JMemberValidator<T extends JMemberData> extends JAnnotatableValidator<T> {

    @Override
    protected void validateContent(T data) {
        log.debug("Validate member " + data.getName());
        if (data.getAccess() == null)
            throw new JCodingValidationException("The member accessor is null for " + data.getName());
        validateName(data);
    }

    protected abstract void validateName(T data);

}
