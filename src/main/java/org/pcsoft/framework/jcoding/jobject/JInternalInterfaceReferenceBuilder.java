package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent an interface reference builder to create a {@link JInternalInterfaceReferenceDescriptor}
 */
public final class JInternalInterfaceReferenceBuilder extends JInternalTypeReferenceBuilder<JInterfaceDescriptor, JInternalInterfaceReferenceDescriptor, JInternalInterfaceReferenceBuilder> implements JInterfaceReferenceBuilder<JInternalInterfaceReferenceDescriptor> {
    public static JInternalInterfaceReferenceBuilder create(JInterfaceDescriptor interfaceDescriptor) {
        return new JInternalInterfaceReferenceBuilder().withType(interfaceDescriptor);
    }

    private JInternalInterfaceReferenceBuilder() {
        super(JInternalInterfaceReferenceDescriptor.class);
    }
}
