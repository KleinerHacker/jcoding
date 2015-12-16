package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Created by Christoph on 16.12.2015.
 */
public interface JTypeReferenceDescriptor extends JReferenceDescriptor {
    /**
     * Get the full class name for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference, see {@link #getTypeReference()}.
     * @param classNamePresentation Presentation type for class name
     * @return
     */
    String getFullClassName(JClassNamePresentation classNamePresentation);

    /**
     * Get the full class name as canonical for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference.
     * @return
     */
    String getFullClassName();

    /**
     * Returns the simple class name for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference.
     * @return
     */
    String getSimpleClassName();

    String getPackageName();
}
