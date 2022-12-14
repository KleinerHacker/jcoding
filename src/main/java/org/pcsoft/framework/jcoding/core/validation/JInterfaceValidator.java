package org.pcsoft.framework.jcoding.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.JInterfaceData;
import org.pcsoft.framework.jcoding.core.validation.base.JTypeValidator;

@Slf4j
public final class JInterfaceValidator extends JTypeValidator<JInterfaceData> {

    @Override
    protected void validateContent(JInterfaceData data) {
        super.validateContent(data);
        log.debug("Validate interface " + data.getName());
    }
}
