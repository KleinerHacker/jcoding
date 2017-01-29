package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Created by Christoph on 29.01.2017.
 */
public abstract class JAnnotatedBuilder<T extends JAnnotatedDescriptor, S extends JAnnotatedBuilder> extends JObjectBuilderBase<T> {

    public JAnnotatedBuilder(Class<T> clazz) {
        super(clazz);
    }

    public S withAnnotation(final JAnnotationReferenceBuilder builder) throws JCodingBuilderException {
        return withAnnotation(builder.build());
    }

    public S withAnnotation(final JAnnotationReferenceDescriptor descriptor) {
        value.getAnnotationList().add(descriptor);
        return (S) this;
    }
}
