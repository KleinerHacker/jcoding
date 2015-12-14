package org.pcsoft.framework.jcoding.jobject;

import org.apache.commons.lang.ClassUtils;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Represent the interface for a java reference object descriptor, based on {@link JObjectDescriptor}.
 */
public interface JReferenceDescriptor extends JObjectDescriptor {

    /**
     * Get the full class name as canonical for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference, see {@link #getTypeReference()}.
     * @return
     */
    public String getFullClassName();

    /**
     * Get the full class name for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference, see {@link #getTypeReference()}.
     * @param classNamePresentation Presentation type for class name
     * @return
     */
    public String getFullClassName(JClassNamePresentation classNamePresentation);

    /**
     * Returns the simple class name for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference, see {@link #getTypeReference()}.
     * @return
     */
    public String getSimpleClassName();

    public String getPackageName();

}
