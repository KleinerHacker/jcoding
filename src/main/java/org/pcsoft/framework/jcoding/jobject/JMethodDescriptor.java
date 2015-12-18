package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent the java method description base implementation.
 */
public abstract class JMethodDescriptor extends JVisibilityDefinitionDescriptor implements JChild, JParent {
    private JReferenceDescriptor returnTypeDescriptor; //Can be null (= void)
    private JTypeDescriptor parent;

    /**
     * Returns the type reference for the method return value
     * @return
     */
    public JReferenceDescriptor getReturnTypeDescriptor() {
        return returnTypeDescriptor;
    }

    void setReturnTypeDescriptor(JReferenceDescriptor returnTypeDescriptor) {
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
