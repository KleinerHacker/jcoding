package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.jobject.type.JTypeReference;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Represent the descriptor for a java type reference base to use e. g. for parameters or field declarations.
 */
public abstract class JTypeReferenceDescriptor<T extends JTypeReference> extends JReferenceDescriptor implements JTypeReference, JObjectDescriptor {
    private T typeReference;

    public T getTypeReference() {
        return typeReference;
    }

    public void setTypeReference(T typeReference) {
        this.typeReference = typeReference;
    }

    @Override
    public final String getFullClassName(JClassNamePresentation classNamePresentation) {
        return typeReference.getFullClassName(classNamePresentation);
    }

    @Override
    public final String getFullClassName() {
        return typeReference.getFullClassName();
    }

    @Override
    public final String getSimpleClassName() {
        return typeReference.getSimpleClassName();
    }

    @Override
    public final String getPackageName() {
        return typeReference.getPackageName();
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (typeReference == null)
            throw new JCodingDescriptorValidationException("No type reference was set");
    }
}
