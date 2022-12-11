package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceData;
import org.pcsoft.framework.jcoding.core.validation.base.JNamedValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JTypeReferenceValidator extends JNamedValidator<JTypeReferenceData> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    private final JPackageReferenceValidator packageReferenceValidator = new JPackageReferenceValidator();

    @Override
    public void validate(JTypeReferenceData data) {
        log.debug("Validate type reference " + data.getName());

        try {
            if (data.getPackageReference() != null) {
                packageReferenceValidator.validate(data.getPackageReference());
            } else {
                log.warn("Type referecne " + data.getName() + " contains no package");
            }
        } catch (JCodingValidationException e) {
            throw new JCodingValidationException("Type reference validation failed for " + data.getName(), e);
        }

        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("Type reference name '" + data.getName() + "' is not allowed");
    }
}
