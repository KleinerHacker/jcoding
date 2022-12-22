package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JGenericData;
import org.pcsoft.framework.jcoding.core.validation.base.JNamedValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JGenericValidator extends JNamedValidator<JGenericData> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    private static final JGenericValidator instance = new JGenericValidator();

    public static JGenericValidator getInstance() {
        return instance;
    }

    private JGenericValidator() {
    }

    @Override
    public void validate(JGenericData data) {
        log.trace("Validate generic " + data.getName());

        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("Name of generic is invalid");
        if (data.getSuperType() != null && data.getExtendsType() != null)
            throw new JCodingValidationException("Generic was set with super and extends: " + data.getName());

        if (data.getSuperType() != null) {
            try {
                JTypeReferenceValidator.getInstance().validate(data.getSuperType());
            } catch (JCodingValidationException e) {
                throw new JCodingValidationException("Failed to validate super type for generic " + data.getName(), e);
            }
        }
        if (data.getExtendsType() != null) {
            try {
                JTypeReferenceValidator.getInstance().validate(data.getExtendsType());
            } catch (Exception e) {
                throw new JCodingValidationException("Failed to validate extends type for generic " + data.getName(), e);
            }
        }
    }
}
