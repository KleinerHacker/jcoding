package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Created by Christoph on 12.12.2015.
 */
public abstract class JInternalTypeReferenceDescriptor<T extends JTypeDescriptor> extends JTypeReferenceDescriptorBase {
    private T typeReference;

    /**
     * Returns the {@link JTypeDescriptor} for this type reference representation
     * @return
     */
    public T getTypeReference() {
        return typeReference;
    }

    void setTypeReference(T typeReference) {
        this.typeReference = typeReference;
    }

    @Override
    public String getFullClassName(JClassNamePresentation presentation) {
        String fullClassName = typeReference.getName();

        JParent currentParent = typeReference.getParent();
        while (currentParent != null) {
            if (currentParent instanceof JTypeDescriptor) {
                //Sub Class
                fullClassName = ((JTypeDescriptor) currentParent).getName() + presentation.getConcatenationCharacter() + fullClassName;
                currentParent = ((JTypeDescriptor) currentParent).getParent();
            } else if (currentParent instanceof JFileDescriptor) {
                //Root Class
                fullClassName = ((JFileDescriptor) currentParent).getPackageName() + "." + fullClassName;
                break;
            } else
                throw new RuntimeException("Unknown parent class: " + currentParent.getClass());
        }

        return fullClassName;
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (typeReference == null)
            throw new JCodingDescriptorValidationException("No type was set!");
    }
}
