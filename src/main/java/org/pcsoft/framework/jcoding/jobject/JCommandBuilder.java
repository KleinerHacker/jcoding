package org.pcsoft.framework.jcoding.jobject;

/**
 * Builder to create a {@link JCommandDescriptor}
 */
public abstract class JCommandBuilder<T extends JCommandDescriptor, S extends JCommandBuilder> extends JObjectBuilderBase<T> {

    public JCommandBuilder(Class<T> clazz) {
        super(clazz);
    }
}
