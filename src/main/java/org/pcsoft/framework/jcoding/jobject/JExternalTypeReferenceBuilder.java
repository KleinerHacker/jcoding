package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public abstract class JExternalTypeReferenceBuilder<T extends JExternalTypeReferenceDescriptor, S extends JExternalTypeReferenceBuilder> extends JTypeReferenceBuilder<T, S> {
    public JExternalTypeReferenceBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withReferenceFullClassName(final Class referenceClass) {
        return withReferenceFullClassName(referenceClass.getCanonicalName());
    }

    public S withReferenceFullClassName(final String referenceFullClassName) {
        value.setFullReferenceClassName(referenceFullClassName);
        return (S) this;
    }
}
