package org.pcsoft.framework.jcoding.core.validation.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.*;
import org.pcsoft.framework.jcoding.core.data.base.JMemberData;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;
import org.pcsoft.framework.jcoding.core.validation.*;
import org.pcsoft.framework.jcoding.exceptions.JCodingValidationException;

import java.util.function.Consumer;

@Slf4j
public abstract class JTypeValidator<T extends JTypeData> extends JMemberValidator<T> {
    private static final String PATTERN = "^[A-Za-z_$][A-Za-z0-9_$]*$";

    @Override
    protected void validateContent(T data) {
        try {
            super.validateContent(data);

            validateMember(JFieldData.class, data, JFieldValidator.getInstance()::validate);
            validateMember(JMethodData.class, data, JMethodValidator.getInstance()::validate);
            validateMember(JClassData.class, data, JClassValidator.getInstance()::validate);
            validateMember(JInterfaceData.class, data, JInterfaceValidator.getInstance()::validate);
            validateMember(JEnumerationData.class, data, JEnumerationValidator.getInstance()::validate);

            data.getSuperInterfaces().forEach(JTypeReferenceValidator.getInstance()::validate);
        } catch (Exception e) {
            throw new JCodingValidationException("Failed to validate type " + data.getName(), e);
        }
    }

    @Override
    protected void validateName(T data) {
        log.debug("Validate type " + data.getName());
        if (!data.getName().matches(PATTERN))
            throw new JCodingValidationException("The name '" + data.getName() + "' is not allowed for type");
    }

    @SuppressWarnings({"FunctionalExpressionCanBeFolded", "unchecked"})
    private <M extends JMemberData> void validateMember(Class<M> clazz, T data, Consumer<M> validator) {
        data.getMembers().stream()
                .filter(x -> clazz.isAssignableFrom(x.getClass()))
                .map(x -> (M) x)
                .forEach(validator::accept);
    }
}
