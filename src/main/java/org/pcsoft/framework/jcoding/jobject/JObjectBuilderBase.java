package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;
import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

/**
 * Base implementation for a java object builder. Contains a java object descriptor and run the build method.
 */
public abstract class JObjectBuilderBase<T extends JObjectDescriptor> implements JObjectBuilder<T> {
    protected final T value;

    public JObjectBuilderBase(final Class<T> clazz) {
        try {
            value = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Unable to initialize descriptor!", e);
        }
    }

    @Override
    public final T build() throws JCodingBuilderException {
        try {
            value.validate();
        } catch (JCodingDescriptorValidationException e) {
            throw new JCodingBuilderException("Unable to build " + value.getClass().getSimpleName() + "!", e);
        }

        return value;
    }
}
