package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JClassData;
import org.pcsoft.framework.jcoding.core.data.JFileData;
import org.pcsoft.framework.jcoding.core.validation.base.JNamedValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JFileValidator extends JNamedValidator<JFileData> {
    private static final String PATTERN = "^([A-Za-z_][A-Za-z0-9_]*)\\.java$";

    private final JPackageValidator packageValidator = new JPackageValidator();
    private final JClassValidator classValidator = new JClassValidator();

    @Override
    public void validate(JFileData data) {
        log.debug("Validate file " + data.getName());

        try {
            if (data.getPackageData() != null) {
                packageValidator.validate(data.getPackageData());
            } else {
                log.warn("File has no package: " + data.getName());
            }
            //Classes
            data.getTypes().stream()
                    .filter(x -> x instanceof JClassData)
                    .map(x -> (JClassData) x)
                    .forEach(classValidator::validateContent);
        } catch (JCodingValidationException e) {
            throw new JCodingValidationException("Validation failed for file " + data.getName(), e);
        }

        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("File with name '" + data.getName() + "' is wrong");
    }
}
