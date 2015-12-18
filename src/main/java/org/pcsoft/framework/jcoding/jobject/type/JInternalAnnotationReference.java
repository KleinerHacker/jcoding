package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JAnnotationDescriptor;

/**
 * Representation of internal annotation descriptor. To create see {@link JAnnotationReference}
 */
public final class JInternalAnnotationReference extends JInternalTypeReference<JAnnotationDescriptor> implements JAnnotationReference {

    JInternalAnnotationReference(JAnnotationDescriptor typeReference) {
        super(typeReference);
    }
}
