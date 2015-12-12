package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent an interface reference builder to create a {@link JInterfaceReferenceDescriptor}
 */
public final class JInterfaceReferenceBuilder extends JTypeReferenceBuilder<JInterfaceDescriptor, JInterfaceReferenceDescriptor, JInterfaceReferenceBuilder> {
    public static JInterfaceReferenceBuilder create(JInterfaceDescriptor interfaceDescriptor) {
        return new JInterfaceReferenceBuilder().withType(interfaceDescriptor);
    }

    private JInterfaceReferenceBuilder() {
        super(JInterfaceReferenceDescriptor.class);
    }
}
