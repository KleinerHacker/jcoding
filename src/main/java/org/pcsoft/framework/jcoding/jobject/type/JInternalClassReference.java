package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JClassDescriptor;

/**
 * Representation of internal class reference. To create see {@link JClassReference}
 */
public final class JInternalClassReference extends JInternalTypeReference<JClassDescriptor> implements JClassReference {

    JInternalClassReference(JClassDescriptor typeReference) {
        super(typeReference);
    }
}
