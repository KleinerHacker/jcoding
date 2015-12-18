package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.jobject.type.JInterfaceReference;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JInterfaceReferenceBuilder extends JInheritableReferenceBuilder<JInterfaceReference, JInterfaceReferenceDescriptor, JInterfaceReferenceBuilder> {
    public static JInterfaceReferenceBuilder create() {
        return new JInterfaceReferenceBuilder();
    }

    public static JInterfaceReferenceBuilder create(final JInterfaceReference interfaceReference) {
        return create().withTypeReference(interfaceReference);
    }

    private JInterfaceReferenceBuilder() {
        super(JInterfaceReferenceDescriptor.class);
    }
}
