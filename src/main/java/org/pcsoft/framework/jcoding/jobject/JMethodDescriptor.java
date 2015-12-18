package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent the java method description base implementation.
 */
public abstract class JMethodDescriptor extends JVisibilityDefinitionDescriptor implements JChild {
    private JTypeReferenceDescriptor returnTypeDescriptor; //Can be null (= void)
    private JTypeDescriptor parent;

    /**
     * Returns the type reference for the method return value
     * @return
     */
    public JTypeReferenceDescriptor getReturnTypeDescriptor() {
        return returnTypeDescriptor;
    }

    void setReturnTypeDescriptor(JTypeReferenceDescriptor returnTypeDescriptor) {
        this.returnTypeDescriptor = returnTypeDescriptor;
    }

    @Override
    public JTypeDescriptor getParent() {
        return parent;
    }

    void setParent(JTypeDescriptor parent) {
        this.parent = parent;
    }
}
