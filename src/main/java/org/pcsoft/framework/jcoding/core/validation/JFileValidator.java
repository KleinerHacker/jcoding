package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.*;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;
import org.pcsoft.framework.jcoding.core.validation.base.JNamedValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

import java.util.function.Consumer;

@Slf4j
public final class JFileValidator extends JNamedValidator<JFileData> {
    private static final String PATTERN = "^([A-Za-z_][A-Za-z0-9_]*)\\.java$";

    private static final JFileValidator instance = new JFileValidator();

    public static JFileValidator getInstance() {
        return instance;
    }

    private JFileValidator() {
    }

    @Override
    public void validate(JFileData data) {
        log.debug("Validate file " + data.getName());

        try {
            if (data.getPackageData() != null) {
                JPackageValidator.getInstance().validate(data.getPackageData());
            } else {
                log.warn("File has no package: " + data.getName());
            }
            validateType(JClassData.class, data, JClassValidator.getInstance()::validate);
            validateType(JInterfaceData.class, data, JInterfaceValidator.getInstance()::validate);
            validateType(JEnumerationData.class, data, JEnumerationValidator.getInstance()::validate);
        } catch (JCodingValidationException e) {
            throw new JCodingValidationException("Validation failed for file " + data.getName(), e);
        }

        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("File with name '" + data.getName() + "' is wrong");
    }

    @SuppressWarnings({"FunctionalExpressionCanBeFolded", "unchecked"})
    private <T extends JTypeData>void validateType(Class<T> clazz, JFileData data, Consumer<T> validator) {
        data.getTypes().stream()
                .filter(x -> clazz.isAssignableFrom(x.getClass()))
                .map(x -> (T) x)
                .forEach(validator::accept);
    }
}
