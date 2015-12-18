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
    private JTypeReferenceDescriptor classExtension;
    private final List<JInterfaceReferenceDescriptor> interfaceExtensionList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JTypeReferenceDescriptor getClassExtension() {
        return classExtension;
    }

    public void setClassExtension(JTypeReferenceDescriptor classExtension) {
        this.classExtension = classExtension;
    }

    public JInterfaceReferenceDescriptor[] getInterfaceExtensions() {
        return interfaceExtensionList.toArray(new JInterfaceReferenceDescriptor[interfaceExtensionList.size()]);
    }

    public void addInterfaceExtension(final JInterfaceReferenceDescriptor interfaceExtension) {
        interfaceExtensionList.add(interfaceExtension);
    }

    public void removeInterfaceExtension(final JInterfaceReferenceDescriptor interfaceExtension) {
        interfaceExtensionList.remove(interfaceExtension);
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (name == null || name.trim().isEmpty())
            throw new JCodingDescriptorValidationException("Name of generic not set!");

        if (classExtension != null) {
            try {
                final Class<?> aClass = Class.forName(classExtension.getFullClassName(JClassNamePresentation.Reference));
                if (aClass.isPrimitive())
                    throw new JCodingDescriptorValidationException("No primitive type is allowed for generic class extension");
            } catch (ClassNotFoundException e) {
                //Ignore
            }
        }
    }
}
