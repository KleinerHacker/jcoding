package org.pcsoft.framework.jcoding.jobject;

/**
 * Base for a value builder to create a {@link JValueDescriptor}
 */
public abstract class JValueBuilder<T extends JValueDescriptor, S extends JValueBuilder> extends JCommandBuilder<T, S> {

    public JValueBuilder(Class<T> clazz) {
        super(clazz);
    }
}
