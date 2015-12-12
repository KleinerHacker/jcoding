package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent a java class reference builder to create a {@link JClassReferenceDescriptor}.
 */
public final class JClassReferenceBuilder extends JTypeReferenceBuilder<JClassDescriptor, JClassReferenceDescriptor, JClassReferenceBuilder> {
    public static JClassReferenceBuilder create(JClassDescriptor classDescriptor) {
        return new JClassReferenceBuilder().withType(classDescriptor);
    }

    private JClassReferenceBuilder() {
        super(JClassReferenceDescriptor.class);
    }
}
