package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Represent the base implementation for a java type builder to create a {@link JTypeDescriptor}
 */
public abstract class JTypeBuilder<M extends JMethodDescriptor, MB extends JMethodBuilder<M, MB>, T extends JTypeDescriptor<M>, S extends JTypeBuilder> extends JVisibilityDefinitionBuilder<T, S> {

    public JTypeBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withStatic(boolean flag) {
        value.setStatic(flag);
        return (S) this;
    }

    public S withChildType(final JTypeDescriptor typeDescriptor) {
        value.addChildType(typeDescriptor);
        return (S) this;
    }

    public S withChildType(final JTypeBuilder typeBuilder) throws JCodingBuilderException {
        return withChildType((JTypeDescriptor) typeBuilder.build());
    }

    public S withChildTypes(final JTypeDescriptor... typeDescriptors) {
        for (final JTypeDescriptor typeDescriptor : typeDescriptors) {
            value.addChildType(typeDescriptor);
        }
        return (S) this;
    }

    public S withChildTypes(final JTypeBuilder... typeBuilders) throws JCodingBuilderException {
        for (final JTypeBuilder typeBuilder : typeBuilders) {
            value.addChildType((JTypeDescriptor) typeBuilder.build());
        }
        return (S) this;
    }

    public S withMethod(final M method) {
        value.addMethod(method);
        return (S) this;
    }

    public S withMethod(final MB method) throws JCodingBuilderException {
        return withMethod((M) method.build());
    }

    public S withMethods(final M... methods) {
        for (final M method : methods) {
            value.addMethod(method);
        }
        return (S) this;
    }

    public S withMethods(final MB... methods) throws JCodingBuilderException {
        for (final MB method : methods) {
            value.addMethod((M) method.build());
        }
        return (S) this;
    }

}
