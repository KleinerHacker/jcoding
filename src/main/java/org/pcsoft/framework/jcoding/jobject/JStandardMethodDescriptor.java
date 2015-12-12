package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JStandardMethodDescriptor extends JParametrizedMethodDescriptor {
    private JMethodBodyDescriptor body;
    private boolean $abstract, $static;

    JStandardMethodDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        super.validate();
        if (body == null && !$abstract)
            throw new JCodingDescriptorValidationException("Body of standard method '" + getName() + "' not set, but is not abstract!");
        if (body != null && $abstract)
            throw new JCodingDescriptorValidationException("Boy of standard method '" + getName() + "' is set, but it is abstract!");
        if ($abstract && getVisibility() == JVisibility.Private)
            throw new JCodingDescriptorValidationException("Method '" + getName() + "' cannot be abstract and private!");
        if ($abstract && $static)
            throw new JCodingDescriptorValidationException("Method '" + getName() + "' cannot be abstract and static!");
    }

    public boolean isAbstract() {
        return $abstract;
    }

    void setAbstract(boolean $abstract) {
        this.$abstract = $abstract;
    }

    public JMethodBodyDescriptor getBody() {
        return body;
    }

    void setBody(JMethodBodyDescriptor body) {
        this.body = body;
    }

    public boolean isStatic() {
        return $static;
    }

    void setStatic(boolean $static) {
        this.$static = $static;
    }
}
