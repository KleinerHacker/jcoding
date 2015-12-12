package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JAnnotationBuilder extends JTypeBuilder<JAnnotationMethodDescriptor, JAnnotationMethodBuilder, JAnnotationDescriptor, JAnnotationBuilder> {
    public static JAnnotationBuilder create(final JVisibility visibility, final String name) {
        return new JAnnotationBuilder().withVisibility(visibility).withName(name);
    }

    public static JAnnotationBuilder create(final String name) {
        return create(JVisibility.Public, name);
    }

    public JAnnotationBuilder() {
        super(JAnnotationDescriptor.class);
    }
}
