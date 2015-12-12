package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent a java class reference builder to create a {@link JInternalClassReferenceDescriptor}.
 */
public final class JInternalClassReferenceBuilder extends JInternalTypeReferenceBuilder<JClassDescriptor, JInternalClassReferenceDescriptor, JInternalClassReferenceBuilder> implements JClassReferenceBuilder<JInternalClassReferenceDescriptor> {
    public static JInternalClassReferenceBuilder create(JClassDescriptor classDescriptor) {
        return new JInternalClassReferenceBuilder().withType(classDescriptor);
    }

    private JInternalClassReferenceBuilder() {
        super(JInternalClassReferenceDescriptor.class);
    }
}
