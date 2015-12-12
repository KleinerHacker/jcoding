package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JPrimitiveValueDescriptor<V> extends JSimpleValueDescriptor<V> {
    private boolean usePrimitive = true;

    public boolean isUsePrimitive() {
        return usePrimitive;
    }

    void setUsePrimitive(boolean usePrimitive) {
        this.usePrimitive = usePrimitive;
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (usePrimitive && getValue() == null)
            throw new JCodingDescriptorValidationException("value is null, but it is a primitive that cannot be null.");
    }
}
