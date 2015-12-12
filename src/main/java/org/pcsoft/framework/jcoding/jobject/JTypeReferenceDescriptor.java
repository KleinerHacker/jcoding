package org.pcsoft.framework.jcoding.jobject;

import org.apache.commons.lang.ClassUtils;
import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.exception.JCodingGenerationException;
import org.pcsoft.framework.jcoding.jobject.JFileDescriptor;
import org.pcsoft.framework.jcoding.jobject.JParent;
import org.pcsoft.framework.jcoding.jobject.JReferenceDescriptorBase;
import org.pcsoft.framework.jcoding.jobject.JTypeDescriptor;
import org.pcsoft.framework.jcoding.management.ImportManagement;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Represent the descriptor for a java type reference base to use e. g. for parameters or field declarations.
 */
public abstract class JTypeReferenceDescriptor<T extends JTypeDescriptor> extends JReferenceDescriptorBase {
    private T typeReference;

    /**
     * Get the full class name as canonical for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference, see {@link #getTypeReference()}.
     * @return
     */
    public String getFullClassName() {
        return getFullClassName(JClassNamePresentation.Canonical);
    }

    /**
     * Get the full class name for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference, see {@link #getTypeReference()}.
     * @param presentation How the class name is to present
     * @return
     */
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

    /**
     * Returns the simple class name for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference, see {@link #getTypeReference()}.
     * @return
     */
    public String getSimpleClassName() {
        final String fullClassName = getFullClassName();
        if (fullClassName == null)
            return null;

        return ClassUtils.getShortClassName(fullClassName);
    }

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
    public void validate() throws JCodingDescriptorValidationException {
        if (typeReference == null)
            throw new JCodingDescriptorValidationException("No type was set!");
    }

    @Override
    public void processImports(ImportManagement importManagement) throws JCodingGenerationException {
        importManagement.add(getFullClassName());
    }
}
