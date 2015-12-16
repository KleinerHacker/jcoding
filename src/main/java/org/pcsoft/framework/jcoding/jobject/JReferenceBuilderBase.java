package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 16.12.2015.
 */
public abstract class JReferenceBuilderBase<T extends JReferenceDescriptorBase, S extends JReferenceBuilderBase> extends JObjectBuilderBase<T> {

    public JReferenceBuilderBase(Class<T> clazz) {
        super(clazz);
    }
}
