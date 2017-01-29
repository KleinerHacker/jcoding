package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

/**
 * Represent the base implementation for a java definition descriptor. See {@link JDefinitionBuilder}
 */
public abstract class JDefinitionDescriptor extends JAnnotatedDescriptor {
    //Validate this fields
    private String name;

    public JDefinitionDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (name == null)
            throw new JCodingDescriptorValidationException("Java class name is not set!");
    }

    /**
     * Returns the name of the definition object
     * @return
     */
    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
