package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.jobject.type.JInheritableReference;

/**
 * Builder base to create {@link JInheritableReferenceDescriptor} based instances
 */
public abstract class JInheritableReferenceBuilder<R extends JInheritableReference, T extends JInheritableReferenceDescriptor<R>, S extends JInheritableReferenceBuilder> extends JTypeReferenceBuilder<R, T, S> {

    public JInheritableReferenceBuilder(Class<T> clazz) {
        super(clazz);
    }
}
