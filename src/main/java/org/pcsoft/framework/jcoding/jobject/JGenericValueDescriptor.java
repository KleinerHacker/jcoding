package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.jobject.type.JTypeReference;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Represent a generic value, e. g. for referenced classes or methods.
 */
public final class JGenericValueDescriptor extends JObjectDescriptorBase {
    private JReferenceDescriptor reference;
    private boolean wildcard;

    JGenericValueDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (reference == null)
            throw new JCodingDescriptorValidationException("type reference not set");
        if (reference instanceof JTypeReference) {
            try {
                final Class<?> aClass = Class.forName(((JTypeReference)reference).getFullClassName(JClassNamePresentation.Reference));
                if (aClass.isPrimitive())
                    throw new JCodingDescriptorValidationException("No primitive value allowed as generic value");
            } catch (ClassNotFoundException e) {
                //Ignore
            }
        }
    }

    public JReferenceDescriptor getReference() {
        return reference;
    }

    public void setReference(JReferenceDescriptor reference) {
        this.reference = reference;
    }

    public boolean isWildcard() {
        return wildcard;
    }

    public void setWildcard(boolean wildcard) {
        this.wildcard = wildcard;
    }
}
