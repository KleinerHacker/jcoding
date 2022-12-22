package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JInterfaceData;
import org.pcsoft.framework.jcoding.core.validation.base.JTypeValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JInterfaceValidator extends JTypeValidator<JInterfaceData> {
    private static final JInterfaceValidator instance = new JInterfaceValidator();

    public static JInterfaceValidator getInstance() {
        return instance;
    }

    private JInterfaceValidator() {
    }

    @Override
    protected void validateContent(JInterfaceData data) {
        try {
            log.trace("Validate interface " + data.getName());
            super.validateContent(data);
        } catch (Exception e) {
            throw new JCodingValidationException("Validation failed for interface " + data.getName(), e);
        }
    }
}
