package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent a Java Type Reference base in e. g. a parameter or field declaration
 */
public abstract class JTypeReferenceBuilder<C extends JTypeDescriptor, T extends JTypeReferenceDescriptor<C>, S extends JTypeReferenceBuilder> extends JObjectBuilderBase<T> {
    /**
     * Creates this builder based on the type descriptor to build reference for
     * @param descriptor
     * @return
     */
    public static JTypeReferenceBuilder create(final JTypeDescriptor descriptor) {
        if (descriptor instanceof JClassDescriptor)
            return create(descriptor);
        else if (descriptor instanceof JInterfaceDescriptor)
            return create(descriptor);
        else if (descriptor instanceof JEnumerationDescriptor)
            return create(descriptor);
        else if (descriptor instanceof JAnnotationDescriptor)
            return create(descriptor);

        throw new RuntimeException();
    }

    public JTypeReferenceBuilder(Class<T> clazz) {
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
