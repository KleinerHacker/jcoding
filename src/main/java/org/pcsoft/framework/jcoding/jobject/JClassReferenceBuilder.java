package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.jobject.type.JClassReference;

/**
 * Builder to create {@link JClassReferenceDescriptor}, based on {@link JClassReference}
 */
public final class JClassReferenceBuilder extends JInheritableReferenceBuilder<JClassReference, JClassReferenceDescriptor, JClassReferenceBuilder> {
    public static JClassReferenceBuilder create() {
        return new JClassReferenceBuilder();
    }

    public static JClassReferenceBuilder create(final JClassReference classReference) {
        return create().withTypeReference(classReference);
    }

    private JClassReferenceBuilder() {
        super(JClassReferenceDescriptor.class);
    }
}
