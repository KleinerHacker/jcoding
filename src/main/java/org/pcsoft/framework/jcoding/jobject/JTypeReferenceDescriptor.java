package org.pcsoft.framework.jcoding.jobject;

import org.apache.commons.lang.ClassUtils;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Represent the descriptor for a java type reference base to use e. g. for parameters or field declarations.
 */
public abstract class JTypeReferenceDescriptor extends JReferenceDescriptorBase {


    /**
     * Get the full class name as canonical for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference.
     * @return
     */
    @Override
    public String getFullClassName() {
        return getFullClassName(JClassNamePresentation.Canonical);
    }

    /**
     * Returns the simple class name for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference.
     * @return
     */
    @Override
    public String getSimpleClassName() {
        final String fullClassName = getFullClassName();
        if (fullClassName == null)
            return null;

        return ClassUtils.getShortClassName(fullClassName);
    }

    @Override
    public String getPackageName() {
        return ClassUtils.getPackageName(getFullClassName());
    }
}
