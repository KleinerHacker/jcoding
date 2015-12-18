package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.jobject.type.JInheritableReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the abstract base for inheritable reference types
 */
public abstract class JInheritableReferenceDescriptor<T extends JInheritableReference> extends JTypeReferenceDescriptor<T> {
    private final List<JGenericValueDescriptor> genericList = new ArrayList<>();

    public JGenericValueDescriptor[] getGenerics() {
        return genericList.toArray(new JGenericValueDescriptor[genericList.size()]);
    }

    public void addGeneric(final JGenericValueDescriptor generic) {
        genericList.add(generic);
    }

    public void removeGeneric(final JGenericValueDescriptor generic) {
        genericList.remove(generic);
    }

}
