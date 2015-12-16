package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;
import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Represent a java class builder to generate a {@link JClassDescriptor} object.
 */
public final class JClassBuilder extends JInheritableTypeBuilder<JClassDescriptor, JClassBuilder> {
    public static JClassBuilder create() {
        return new JClassBuilder();
    }

    public static JClassBuilder create(final JVisibility visibility, final String name) {
        return create().withVisibility(visibility).withName(name);
    }

    public static JClassBuilder create(final String name) {
        return create(JVisibility.Public, name);
    }

    private JClassBuilder() {
        super(JClassDescriptor.class);
    }

    public JClassBuilder withFinal(final boolean flag) {
        value.setFinal(flag);
        return this;
    }

    public JClassBuilder withAbstract(final boolean flag) {
        value.setAbstract(flag);
        return this;
    }

    public JClassBuilder withSuperClass(final JClassReferenceBuilder superClass) throws JCodingBuilderException {
        return withSuperClass((JClassReferenceDescriptor) superClass.build());
    }

    public JClassBuilder withSuperClass(final JClassReferenceDescriptor superClass) {
        value.setSuperClass(superClass);
        return this;
    }
}
