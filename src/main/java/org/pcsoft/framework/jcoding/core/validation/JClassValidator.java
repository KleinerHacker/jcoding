package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JClassData;
import org.pcsoft.framework.jcoding.core.validation.base.JTypeValidator;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

@Slf4j
public final class JClassValidator extends JTypeValidator<JClassData> {
    @Override
    protected void validateContent(JClassData data) {
        super.validateContent(data);
        log.debug("Validate class " + data.getName());
        if (data.isStatic() && data.isAbstract())
            throw new JCodingValidationException("Modifier abstract and static was set for class " + data.getName());
    }
}
