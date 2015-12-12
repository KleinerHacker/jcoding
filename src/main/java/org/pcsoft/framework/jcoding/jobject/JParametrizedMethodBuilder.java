package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Base for parametrized method builder.
 */
public abstract class JParametrizedMethodBuilder<T extends JParametrizedMethodDescriptor, S extends JParametrizedMethodBuilder> extends JMethodBuilder<T, S> {

    public JParametrizedMethodBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withParameter(final JParameterBuilder parameter) throws JCodingBuilderException {
        return withParameter(parameter.build());
    }

    public S withParameter(final JParameterDescriptor parameter) {
        value.addParameter(parameter);
        return (S) this;
    }

    public S withParameters(final JParameterBuilder... parameters) throws JCodingBuilderException {
        for (final JParameterBuilder parameter : parameters) {
            value.addParameter(parameter.build());
        }
        return (S) this;
    }

    public S withParameters(final JParameterDescriptor... parameters) {
        for (final JParameterDescriptor parameter : parameters) {
            value.addParameter(parameter);
        }
        return (S) this;
    }

}
