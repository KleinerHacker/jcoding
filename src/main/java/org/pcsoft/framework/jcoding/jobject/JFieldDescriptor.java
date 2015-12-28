package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

/**
 * Represent a field descriptor. Build with {@link JFieldDescriptor}
 */
public final class JFieldDescriptor extends JVisibilityDefinitionDescriptor {
    private boolean $static, $final;
    private JReferenceDescriptor type;
    private JValueDescriptor value;

    JFieldDescriptor() {
    }

    public boolean isStatic() {
        return $static;
    }

    public void setStatic(boolean $static) {
        this.$static = $static;
    }

    public boolean isFinal() {
        return $final;
    }

    public void setFinal(boolean $final) {
        this.$final = $final;
    }

    public JReferenceDescriptor getType() {
        return type;
    }

    public void setType(JReferenceDescriptor type) {
        this.type = type;
    }

    public JValueDescriptor getValue() {
        return value;
    }

    public void setValue(JValueDescriptor value) {
        this.value = value;
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        super.validate();

        if (type == null)
            throw new JCodingDescriptorValidationException("Type for field '" + getName() + "' not set!");
    }
}
