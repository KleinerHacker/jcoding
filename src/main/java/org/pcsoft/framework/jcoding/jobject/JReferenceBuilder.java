package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 16.12.2015.
 */
public abstract class JReferenceBuilder<T extends JReferenceDescriptor, S extends JReferenceBuilder> extends JObjectBuilderBase<T> {

    public JReferenceBuilder(Class<T> clazz) {
        super(clazz);
    }
}
