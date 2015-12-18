package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JInterfaceDescriptor;

/**
 * Representation of internal interface reference. To create see {@link JInterfaceReference}
 */
public final class JInternalInterfaceReference extends JInternalTypeReference<JInterfaceDescriptor> implements JInterfaceReference {

    JInternalInterfaceReference(JInterfaceDescriptor typeReference) {
        super(typeReference);
    }
}
