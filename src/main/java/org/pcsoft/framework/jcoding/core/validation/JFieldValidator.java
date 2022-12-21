package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JFieldData;
import org.pcsoft.framework.jcoding.core.validation.base.JMemberValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JFieldValidator extends JMemberValidator<JFieldData> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    private static final JFieldValidator instance = new JFieldValidator();

    public static JFieldValidator getInstance() {
        return instance;
    }

    private JFieldValidator() {
    }

    @Override
    protected void validateContent(JFieldData data) {
        log.debug("Validate field " + data.getName());

        if (data.getType() == null)
            throw new JCodingValidationException("The type of field " + data.getName() + " is set to null");

        try {
            super.validateContent(data);
            JTypeReferenceValidator.getInstance().validate(data.getType());
        } catch (Exception e) {
            throw new JCodingValidationException("Validation failed for field " + data.getName(), e);
        }
    }

    @Override
    protected void validateName(JFieldData data) {
        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("The name '" + data.getName() + "' is not allowed for field");
    }
}
