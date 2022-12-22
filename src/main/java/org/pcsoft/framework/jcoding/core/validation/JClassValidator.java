package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JClassData;
import org.pcsoft.framework.jcoding.core.validation.base.JTypeValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JClassValidator extends JTypeValidator<JClassData> {
    private static final JClassValidator instance = new JClassValidator();

    public static JClassValidator getInstance() {
        return instance;
    }

    private JClassValidator() {
    }

    @Override
    protected void validateContent(JClassData data) {
        log.trace("Validate class " + data.getName());
        if (data.isAbstract() && data.isFinal())
            throw new JCodingValidationException("Modifier abstract and final was set for class " + data.getName());

        try {
            super.validateContent(data);
            if (data.getSuperType() != null) {
                JTypeReferenceValidator.getInstance().validate(data.getSuperType());
            }
        } catch (Exception e) {
            throw new JCodingValidationException("Validation failed for class " + data.getName(), e);
        }
    }
}
