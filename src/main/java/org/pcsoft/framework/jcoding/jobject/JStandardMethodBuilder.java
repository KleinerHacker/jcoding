package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;
import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JStandardMethodBuilder extends JParametrizedMethodBuilder<JStandardMethodDescriptor, JStandardMethodBuilder> {
    public static JStandardMethodBuilder create(final JVisibility visibility, final String name, final JTypeReferenceBuilderBase returnType) throws JCodingBuilderException {
        return new JStandardMethodBuilder().withVisibility(visibility).withName(name).withReturnType(returnType);
    }

    public static JStandardMethodBuilder create(final JVisibility visibility, final String name, final JTypeReferenceDescriptorBase returnType) {
        return new JStandardMethodBuilder().withVisibility(visibility).withName(name).withReturnType(returnType);
    }

    public static JStandardMethodBuilder create(final JVisibility visibility, final String name) {
        return create(visibility, name, (JTypeReferenceDescriptorBase) null);
    }

    public static JStandardMethodBuilder create(final String name, final JTypeReferenceBuilderBase returnType) throws JCodingBuilderException {
        return create(JVisibility.Public, name, returnType);
    }

    public static JStandardMethodBuilder create(final String name, final JTypeReferenceDescriptorBase returnType) {
        return create(JVisibility.Public, name, returnType);
    }

    public static JStandardMethodBuilder create(final String name) {
        return create(name, (JTypeReferenceDescriptorBase) null);
    }

    private JStandardMethodBuilder() {
        super(JStandardMethodDescriptor.class);
    }

    public JStandardMethodBuilder withBody(final JMethodBodyBuilder body) throws JCodingBuilderException {
        return withBody(body.build());
    }

    public JStandardMethodBuilder withBody(final JMethodBodyDescriptor body) {
        value.setBody(body);
        return this;
    }

    public JStandardMethodBuilder withStatic(final boolean flag) {
        value.setStatic(flag);
        return this;
    }
}
