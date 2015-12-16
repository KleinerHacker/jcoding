package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JGenericDescriptor extends JObjectDescriptorBase {
    private String name;
    private JTypeReferenceDescriptorBase classExtension;
    private final List<JInternalInterfaceReferenceDescriptor> interfaceExtensionList = new ArrayList<>();

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public JTypeReferenceDescriptorBase getClassExtension() {
        return classExtension;
    }

    void setClassExtension(JTypeReferenceDescriptorBase classExtension) {
        this.classExtension = classExtension;
    }

    public JInternalInterfaceReferenceDescriptor[] getInterfaceExtensions() {
        return interfaceExtensionList.toArray(new JInternalInterfaceReferenceDescriptor[interfaceExtensionList.size()]);
    }

    void addInterfaceExtension(final JInternalInterfaceReferenceDescriptor interfaceExtension) {
        interfaceExtensionList.add(interfaceExtension);
    }

    void removeInterfaceExtension(final JInternalInterfaceReferenceDescriptor interfaceExtension) {
        interfaceExtensionList.remove(interfaceExtension);
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (name == null || name.trim().isEmpty())
            throw new JCodingDescriptorValidationException("Name of generic not set!");
    }
}
