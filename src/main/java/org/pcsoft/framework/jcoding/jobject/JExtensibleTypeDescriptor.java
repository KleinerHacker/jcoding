package org.pcsoft.framework.jcoding.jobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JExtensibleTypeDescriptor extends JTypeDescriptor<JStandardMethodDescriptor> {
    private final List<JInterfaceReferenceDescriptor> interfaceList = new ArrayList<>();

    JExtensibleTypeDescriptor() {
    }

    public JInterfaceReferenceDescriptor[] getInterfaces() {
        return interfaceList.toArray(new JInterfaceReferenceDescriptor[interfaceList.size()]);
    }

    void addInterface(final JInterfaceReferenceDescriptor $interface) {
        interfaceList.add($interface);
    }

    void removeInterface(final JInterfaceReferenceDescriptor $interface) {
        interfaceList.remove($interface);
    }
}
