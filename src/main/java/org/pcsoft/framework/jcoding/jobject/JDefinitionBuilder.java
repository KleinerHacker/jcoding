package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent the base implementation for a java definition builder to create a {@link JDefinitionDescriptor}
 */
public abstract class JDefinitionBuilder<T extends JDefinitionDescriptor, S extends JDefinitionBuilder> extends JObjectBuilderBase<T> {

    public JDefinitionBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withName(final String name) {
        value.setName(name);
        return (S)this;
    }

}
