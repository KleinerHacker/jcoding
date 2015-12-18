package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JEnumerationDescriptor;

/**
 * Representation of internal enumeration reference. To create see {@link JEnumerationReference}
 */
public final class JInternalEnumerationReference extends JInternalTypeReference<JEnumerationDescriptor> implements JEnumerationReference {

    JInternalEnumerationReference(JEnumerationDescriptor typeReference) {
        super(typeReference);
    }
}
