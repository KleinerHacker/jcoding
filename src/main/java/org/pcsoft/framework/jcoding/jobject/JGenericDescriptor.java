package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

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

    public void setName(String name) {
        this.name = name;
    }

    public JTypeReferenceDescriptorBase getClassExtension() {
        return classExtension;
    }

    public void setClassExtension(JTypeReferenceDescriptorBase classExtension) {
        this.classExtension = classExtension;
    }

    public JInternalInterfaceReferenceDescriptor[] getInterfaceExtensions() {
        return interfaceExtensionList.toArray(new JInternalInterfaceReferenceDescriptor[interfaceExtensionList.size()]);
    }

    public void addInterfaceExtension(final JInternalInterfaceReferenceDescriptor interfaceExtension) {
        interfaceExtensionList.add(interfaceExtension);
    }

    public void removeInterfaceExtension(final JInternalInterfaceReferenceDescriptor interfaceExtension) {
        interfaceExtensionList.remove(interfaceExtension);
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (name == null || name.trim().isEmpty())
            throw new JCodingDescriptorValidationException("Name of generic not set!");

        try {
            final Class<?> aClass = Class.forName(classExtension.getFullClassName(JClassNamePresentation.Reference));
            if (aClass.isPrimitive())
                throw new JCodingDescriptorValidationException("No primitive type is allowed for generic class extension");
        } catch (ClassNotFoundException e) {
            //Ignore
        }
    }
}
