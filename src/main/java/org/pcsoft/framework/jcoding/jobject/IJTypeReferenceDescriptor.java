package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Created by Christoph on 12.12.2015.
 */
public interface IJTypeReferenceDescriptor {
    String getFullClassName();

    /**
     * Get the full class name for this type reference representation or NULL if no {@link JFileDescriptor} was found for the contained type reference, see {@link #getTypeReference()}.
     * @param presentation How the class name is to present
     * @return
     */
    String getFullClassName(JClassNamePresentation presentation);

    String getSimpleClassName();

    String getPackageName();
}
