package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;
import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JAnnotationMethodBuilder extends JMethodBuilder<JAnnotationMethodDescriptor, JAnnotationMethodBuilder> {
    public static JAnnotationMethodBuilder create() {
        return new JAnnotationMethodBuilder();
    }

    public static JAnnotationMethodBuilder create(final JVisibility visibility, final String name, final JTypeReferenceDescriptor returnType) {
        return create().withVisibility(visibility).withName(name).withReturnType(returnType);
    }

    public static JAnnotationMethodBuilder create(final JVisibility visibility, final String name) {
        return create(visibility, name, null);
    }

    public static JAnnotationMethodBuilder create(final String name, final JTypeReferenceDescriptor returnType) {
        return create(JVisibility.Public, name, returnType);
    }

    public static JAnnotationMethodBuilder create(final String name) {
        return create(name, null);
    }

    private JAnnotationMethodBuilder() {
        super(JAnnotationMethodDescriptor.class);
    }

    public JAnnotationMethodBuilder withDefaultValue(final JValueBuilder valueBuilder) throws JCodingBuilderException {
        return withDefaultValue((JValueDescriptor) valueBuilder.build());
    }

    public JAnnotationMethodBuilder withDefaultValue(final JValueDescriptor valueDescriptor) {
        value.setDefaultValue(valueDescriptor);
        return this;
    }
}
