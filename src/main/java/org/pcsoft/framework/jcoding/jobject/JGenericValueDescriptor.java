package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Represent a generic value, e. g. for referenced classes or methods.
 */
public final class JGenericValueDescriptor extends JObjectDescriptorBase {
    private JTypeReferenceDescriptor typeReference;
    private boolean wildcard;

    JGenericValueDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (typeReference == null)
            throw new JCodingDescriptorValidationException("type reference not set");
        try {
            final Class<?> aClass = Class.forName(typeReference.getFullClassName(JClassNamePresentation.Reference));
            if (aClass.isPrimitive())
                throw new JCodingDescriptorValidationException("No primitive value allowed as generic value");
        } catch (ClassNotFoundException e) {
            //Ignore
        }
    }

    public JTypeReferenceDescriptor getTypeReference() {
        return typeReference;
    }

    public void setTypeReference(JTypeReferenceDescriptor typeReference) {
        this.typeReference = typeReference;
    }

    public boolean isWildcard() {
        return wildcard;
    }

    public void setWildcard(boolean wildcard) {
        this.wildcard = wildcard;
    }
}
