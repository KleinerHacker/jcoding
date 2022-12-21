package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JPackageData;
import org.pcsoft.framework.jcoding.core.validation.base.JAnnotatableValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JPackageValidator extends JAnnotatableValidator<JPackageData> {
    public static final String PATTERN = "^([A-Za-z_][A-Za-z0-9_]*)(\\.[A-Za-z_][A-Za-z0-9_]*)*$";

    private static final JPackageValidator instance = new JPackageValidator();

    public static JPackageValidator getInstance() {
        return instance;
    }

    private JPackageValidator() {
    }

    @Override
    protected void validateContent(JPackageData data) {
        log.debug("Validate package " + data.getName());
        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("Package name '" + data.getName() + "' not allowed");
    }
}
