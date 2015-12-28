package org.pcsoft.framework.jcoding.jobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JExtensibleTypeDescriptor extends JTypeDescriptor<JStandardMethodDescriptor> {
    private final List<JInterfaceReferenceDescriptor> interfaceList = new ArrayList<>();
    private final List<JFieldDescriptor> fieldList = new ArrayList<>();

    JExtensibleTypeDescriptor() {
    }

    public JInterfaceReferenceDescriptor[] getInterfaces() {
        return interfaceList.toArray(new JInterfaceReferenceDescriptor[interfaceList.size()]);
    }

    public void addInterface(final JInterfaceReferenceDescriptor $interface) {
        interfaceList.add($interface);
    }

    public void removeInterface(final JInterfaceReferenceDescriptor $interface) {
        interfaceList.remove($interface);
    }

    public JFieldDescriptor[] getFields() {
        return fieldList.toArray(new JFieldDescriptor[fieldList.size()]);
    }

    public void addField(final JFieldDescriptor field) {
        fieldList.add(field);
    }

    public void removeField(final JFieldDescriptor field) {
        fieldList.remove(field);
    }
}
