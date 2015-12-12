package org.pcsoft.framework.jcoding.jobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the base implementation for a java type descriptor. See {@link JTypeBuilder}
 */
public abstract class JTypeDescriptor<M extends JMethodDescriptor> extends JVisibilityDefinitionDescriptor implements JParent, JChild {
    private boolean $static = false;

    //Do not validate this fields
    private JParent parent;
    private final List<JTypeDescriptor> childTypeList = new ArrayList<>();
    private final List<M> methodList = new ArrayList<>();

    /**
     * returns the static flag for this type
     * @return
     */
    public boolean isStatic() {
        return $static;
    }

    void setStatic(boolean $static) {
        this.$static = $static;
    }

    /**
     * Returns the parent for this type
     * @return
     */
    @Override
    public JParent getParent() {
        return parent;
    }

    void setParent(JParent parent) {
        this.parent = parent;
    }

    public JTypeDescriptor[] getChildTypes() {
        return childTypeList.toArray(new JTypeDescriptor[childTypeList.size()]);
    }

    void addChildType(final JTypeDescriptor typeDescriptor) {
        typeDescriptor.setParent(this);
        childTypeList.add(typeDescriptor);
    }

    void removeChildType(final JTypeDescriptor typeDescriptor) {
        typeDescriptor.setParent(null);
        childTypeList.remove(typeDescriptor);
    }

    public M[] getMethods() {
        return (M[])methodList.toArray(new JMethodDescriptor[methodList.size()]);
    }

    void addMethod(final M method) {
        method.setParent(this);
        methodList.add(method);
    }

    void removeMethod(final M method) {
        method.setParent(null);
        methodList.remove(method);
    }
}
