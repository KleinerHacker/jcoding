package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.jobject.type.*;

/**
 * Represent a Java Type Reference base in e. g. a parameter or field declaration
 */
public abstract class JTypeReferenceBuilder<R extends JTypeReference, T extends JTypeReferenceDescriptor<R>, S extends JTypeReferenceBuilder> extends JReferenceBuilder<T, S> {
    /**
     * Creates this builder based on the type descriptor to build reference for
     *
     * @param descriptor
     * @return
     */
    public static JTypeReferenceBuilder create(final JTypeReference descriptor) {
        if (descriptor instanceof JClassReference)
            return JClassReferenceBuilder.create((JClassReference) descriptor);
        else if (descriptor instanceof JInterfaceReference)
            return JInterfaceReferenceBuilder.create((JInterfaceReference) descriptor);
        else if (descriptor instanceof JEnumerationReference)
            return JEnumerationReferenceBuilder.create((JEnumerationReference) descriptor);
        else if (descriptor instanceof JAnnotationReference)
            return JAnnotationReferenceBuilder.create((JAnnotationReference) descriptor);

        throw new RuntimeException();
    }

    public JTypeReferenceBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withTypeReference(final R typeReference) {
        value.setTypeReference(typeReference);
        return (S) this;
    }
}
