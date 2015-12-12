package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

/**
 * Represent a java class descriptor. Please use {@link JClassBuilder} to generate this object.
 */
public final class JClassDescriptor extends JInheritableTypeDescriptor {
    private JClassReferenceDescriptor superClass;
    private boolean $final = false;
    private boolean $abstract = false;

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        super.validate();
        if ($final && $abstract)
            throw new JCodingDescriptorValidationException("Class '" + getName() + "' is final and abstract");
    }

    /**
     * Returns the final flag for this class
     * @return
     */
    public boolean isFinal() {
        return $final;
    }

    void setFinal(boolean $final) {
        this.$final = $final;
    }

    /**
     * Returns the abstract flag for this class
     * @return
     */
    public boolean isAbstract() {
        return $abstract;
    }

    void setAbstract(boolean $abstract) {
        this.$abstract = $abstract;
    }

    /**
     * Returns the super class reference for this class
     * @return
     */
    public JClassReferenceDescriptor getSuperClass() {
        return superClass;
    }

    void setSuperClass(JClassReferenceDescriptor superClass) {
        this.superClass = superClass;
    }
}
