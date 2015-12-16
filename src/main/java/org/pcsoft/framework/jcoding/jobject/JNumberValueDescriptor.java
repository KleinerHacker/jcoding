package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JNumberType;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JNumberValueDescriptor extends JPrimitiveValueDescriptor<Number> {
    private JNumberType number;

    JNumberValueDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (number == null)
            throw new JCodingDescriptorValidationException("type of number not set!");
    }

    public JNumberType getNumber() {
        return number;
    }

    public void setNumber(JNumberType number) {
        this.number = number;
    }
}
