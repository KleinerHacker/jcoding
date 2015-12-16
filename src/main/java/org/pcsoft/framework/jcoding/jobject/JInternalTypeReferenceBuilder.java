package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public abstract class JInternalTypeReferenceBuilder<C extends JTypeDescriptor, T extends JInternalTypeReferenceDescriptor, S extends JInternalTypeReferenceBuilder> extends JTypeReferenceBuilderBase<T, S> {

    public JInternalTypeReferenceBuilder(Class<T> clazz) {
        super(clazz);
    }

    /**
     * Set the type for this type reference
     * @param typeDescriptor
     * @return
     */
    public S withType(final C typeDescriptor) {
        value.setTypeReference(typeDescriptor);
        return (S)this;
    }
}
