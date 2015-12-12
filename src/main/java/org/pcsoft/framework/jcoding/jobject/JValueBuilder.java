package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JValueBuilder<T extends JValueDescriptor, S extends JValueBuilder> extends JObjectBuilderBase<T> {

    public JValueBuilder(Class<T> clazz) {
        super(clazz);
    }
}
