package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent a Java Type Reference base in e. g. a parameter or field declaration
 */
public abstract class JTypeReferenceBuilder<T extends JTypeReferenceDescriptor, S extends JTypeReferenceBuilder> extends JObjectBuilderBase<T> {
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

    public static JTypeReferenceBuilder create(final Class clazz) {
        if (clazz.isAnnotation()) {
            return JExternalAnnotationReferenceBuilder.create(clazz);
        } else if (clazz.isEnum()) {
            return JExternalEnumerationReferenceBuilder.create(clazz);
        } else if (clazz.isInterface()) {
            return JExternalInterfaceReferenceBuilder.create(clazz);
        } else {
            return JExternalClassReferenceBuilder.create(clazz);
        }
    }

    public JTypeReferenceBuilder(Class<T> clazz) {
        super(clazz);
    }

    
}
