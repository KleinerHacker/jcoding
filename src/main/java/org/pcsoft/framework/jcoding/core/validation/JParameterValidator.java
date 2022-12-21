package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JParameterData;
import org.pcsoft.framework.jcoding.core.validation.base.JAnnotatableValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JParameterValidator extends JAnnotatableValidator<JParameterData> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    private static final JParameterValidator instance = new JParameterValidator();

    public static JParameterValidator getInstance() {
        return instance;
    }

    private JParameterValidator() {
    }

    @Override
    protected void validateContent(JParameterData data) {
        log.debug("Validate parameter " + data.getName());

        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("The name '" + data.getName() + "' is not allowed for parameter");
        if (data.getType() == null)
            throw new JCodingValidationException("The type of parameter " + data.getName() + " is set to null");

        try {
            JTypeReferenceValidator.getInstance().validate(data.getType());
        } catch (Exception e) {
            throw new JCodingValidationException("Validation failed for parameter " + data.getName(), e);
        }
    }
}
