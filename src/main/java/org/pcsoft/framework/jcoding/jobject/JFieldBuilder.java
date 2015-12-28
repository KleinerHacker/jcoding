package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;
import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Builder to create a {@link JFieldDescriptor}
 */
public final class JFieldBuilder extends JVisibilityDefinitionBuilder<JFieldDescriptor, JFieldBuilder> {
    public static JFieldBuilder create() {
        return new JFieldBuilder();
    }

    public static JFieldBuilder create(final JVisibility visibility, final String name, final JReferenceBuilder type) throws JCodingBuilderException {
        return create(visibility, name, (JReferenceDescriptor) type.build());
    }

    public static JFieldBuilder create(final JVisibility visibility, final String name, final JReferenceDescriptor type) {
        return create().withVisibility(visibility).withType(type).withName(name);
    }

    public static JFieldBuilder create(final String name, final JReferenceBuilder type) throws JCodingBuilderException {
        return create(name, (JReferenceDescriptor) type.build());
    }

    public static JFieldBuilder create(final String name, final JReferenceDescriptor type) {
        return create(JVisibility.Public, name, type);
    }

    private JFieldBuilder() {
        super(JFieldDescriptor.class);
    }

    public JFieldBuilder withStatic(final boolean flag) {
        value.setStatic(flag);
        return this;
    }

    public JFieldBuilder withFinal(final boolean flag) {
        value.setFinal(flag);
        return this;
    }

    public JFieldBuilder withType(final JReferenceDescriptor type) {
        super.value.setType(type);
        return this;
    }

    public JFieldBuilder withType(final JReferenceBuilder type) throws JCodingBuilderException {
        return withType((JReferenceDescriptor) type.build());
    }

    public JFieldBuilder withValue(final JValueDescriptor value) {
        super.value.setValue(value);
        return this;
    }

    public JFieldBuilder withValue(final JValueBuilder value) throws JCodingBuilderException {
        return withValue((JValueDescriptor) value.build());
    }
}
