package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;
import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JStandardMethodBuilder extends JParametrizedMethodBuilder<JStandardMethodDescriptor, JStandardMethodBuilder> {
    public static JStandardMethodBuilder create() {
        return new JStandardMethodBuilder();
    }

    public static JStandardMethodBuilder create(final JVisibility visibility, final String name, final JReferenceBuilder returnType) throws JCodingBuilderException {
        return create().withVisibility(visibility).withName(name).withReturnType(returnType);
    }

    public static JStandardMethodBuilder create(final JVisibility visibility, final String name, final JReferenceDescriptor returnType) {
        return create().withVisibility(visibility).withName(name).withReturnType(returnType);
    }

    public static JStandardMethodBuilder create(final JVisibility visibility, final String name) {
        return create(visibility, name, (JTypeReferenceDescriptor) null);
    }

    public static JStandardMethodBuilder create(final String name, final JReferenceBuilder returnType) throws JCodingBuilderException {
        return create(JVisibility.Public, name, returnType);
    }

    public static JStandardMethodBuilder create(final String name, final JReferenceDescriptor returnType) {
        return create(JVisibility.Public, name, returnType);
    }

    public static JStandardMethodBuilder create(final String name) {
        return create(name, (JTypeReferenceDescriptor) null);
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

    public JStandardMethodBuilder withThrow(final JClassReferenceBuilder $throw) throws JCodingBuilderException {
        return withThrow($throw.build());
    }

    public JStandardMethodBuilder withThrow(final JClassReferenceDescriptor $throw) {
        value.addThrow($throw);
        return this;
    }

    public JStandardMethodBuilder withThrows(final JClassReferenceBuilder... $throws) throws JCodingBuilderException {
        for (final JClassReferenceBuilder $throw : $throws) {
            value.addThrow($throw.build());
        }
        return this;
    }

    public JStandardMethodBuilder withThrows(final JClassReferenceDescriptor... $throws) {
        for (final JClassReferenceDescriptor $throw : $throws) {
            value.addThrow($throw);
        }
        return this;
    }
}
