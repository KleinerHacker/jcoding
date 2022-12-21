package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JMethodData;
import org.pcsoft.framework.jcoding.core.validation.base.JMemberValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JMethodValidator extends JMemberValidator<JMethodData> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    private static final JMethodValidator instance = new JMethodValidator();

    public static JMethodValidator getInstance() {
        return instance;
    }

    private JMethodValidator() {
    }

    @Override
    protected void validateContent(JMethodData data) {
        log.debug("Validate method " + data.getName());

        if (data.isStatic() && (data.isFinal() || data.isAbstract()))
            throw new JCodingValidationException("Cannot set static in combination with abstract or final in method " + data.getName());
        if (data.isFinal() && data.isAbstract())
            throw new JCodingValidationException("Cannot set abstract and final in method " + data.getName());

        try {
            super.validateContent(data);
            if (data.getReturnType() != null) {
                JTypeReferenceValidator.getInstance().validate(data.getReturnType());
            }
        } catch (Exception e) {
            throw new JCodingValidationException("Validation failed for method " + data.getName(), e);
        }
    }

    @Override
    protected void validateName(JMethodData data) {
        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("The name '" + data.getName() + "' is not allowed for method");
    }
}
