package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JEnumerationData;
import org.pcsoft.framework.jcoding.core.validation.base.JTypeValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JEnumerationValidator extends JTypeValidator<JEnumerationData> {
    private static final JEnumerationValidator instance = new JEnumerationValidator();

    public static JEnumerationValidator getInstance() {
        return instance;
    }

    private JEnumerationValidator() {
    }

    @Override
    protected void validateContent(JEnumerationData data) {
        log.trace("Validate enumeration " + data.getName());
        try {
            super.validateContent(data);
        } catch (Exception e) {
            throw new JCodingValidationException("Validation failed for enumeration " + data.getName(), e);
        }
    }
}
