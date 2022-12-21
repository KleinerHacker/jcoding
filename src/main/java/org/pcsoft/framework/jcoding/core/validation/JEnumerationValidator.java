package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JEnumerationData;
import org.pcsoft.framework.jcoding.core.validation.base.JTypeValidator;

@Slf4j
public final class JEnumerationValidator extends JTypeValidator<JEnumerationData> {
    private static final JEnumerationValidator instance = new JEnumerationValidator();

    public static JEnumerationValidator getInstance() {
        return instance;
    }

    private JEnumerationValidator() {
    }

    @Override
    protected void validateContent(JEnumerationData data) {
        super.validateContent(data);
        log.debug("Validate enumeration " + data.getName());
    }
}
