package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JPackageReferenceData;
import org.pcsoft.framework.jcoding.core.validation.base.JNamedValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JPackageReferenceValidator extends JNamedValidator<JPackageReferenceData> {
    public static final String PATTERN = "^([A-Za-z_][A-Za-z0-9_]*)(\\.[A-Za-z_][A-Za-z0-9_]*)*$";

    @Override
    public void validate(JPackageReferenceData data) {
        log.debug("Validate package reference " + data.getName());
        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("package reference name '" + data.getName() + "' not allowed");
    }
}
