package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JStandardMethodDescriptor extends JParametrizedMethodDescriptor {
    private JMethodBodyDescriptor body;
    private boolean $static;

    JStandardMethodDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        super.validate();
        if (isAbstract() && getVisibility() == JVisibility.Private)
            throw new JCodingDescriptorValidationException("Method '" + getName() + "' cannot be abstract and private!");
        if (isAbstract() && $static)
            throw new JCodingDescriptorValidationException("Method '" + getName() + "' cannot be abstract and static!");
    }

    public boolean isAbstract() {
        return body == null;
    }

    public JMethodBodyDescriptor getBody() {
        return body;
    }

    public void setBody(JMethodBodyDescriptor body) {
        this.body = body;
    }

    public boolean isStatic() {
        return $static;
    }

    public void setStatic(boolean $static) {
        this.$static = $static;
    }
}
