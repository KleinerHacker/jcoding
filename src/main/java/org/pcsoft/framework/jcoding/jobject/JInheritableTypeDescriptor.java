package org.pcsoft.framework.jcoding.jobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christoph on 12.12.2015.
 */
public abstract class JInheritableTypeDescriptor extends JExtensibleTypeDescriptor {
    private final List<JGenericDescriptor> genericList = new ArrayList<>();

    public JInheritableTypeDescriptor() {
    }

    public JGenericDescriptor[] getGenerics() {
        return genericList.toArray(new JGenericDescriptor[genericList.size()]);
    }

    void addGeneric(final JGenericDescriptor generic) {
        genericList.add(generic);
    }

    void removeGeneric(final JGenericDescriptor generic) {
        genericList.remove(generic);
    }
}
