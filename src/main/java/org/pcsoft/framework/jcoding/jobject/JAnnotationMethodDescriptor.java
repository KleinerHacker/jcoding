package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JAnnotationMethodDescriptor extends JMethodDescriptor {
    private JValueDescriptor defaultValue;

    JAnnotationMethodDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        super.validate();
        if (getReturnTypeDescriptor() != null) {
            final String fullClassName = getReturnTypeDescriptor().getFullClassName();
            if (!fullClassName.equals(String.class.getCanonicalName()) && !fullClassName.equals(byte.class.getCanonicalName()) &&
                    !fullClassName.equals(short.class.getCanonicalName()) && !fullClassName.equals(int.class.getCanonicalName()) &&
                    !fullClassName.equals(long.class.getCanonicalName()) && !fullClassName.equals(double.class.getCanonicalName()) &&
                    !fullClassName.equals(float.class.getCanonicalName()) && !fullClassName.equals(boolean.class.getCanonicalName()) &&
                    !fullClassName.equals(char.class.getCanonicalName()) &&
                    (getReturnTypeDescriptor() == null || !(getReturnTypeDescriptor() instanceof JEnumerationReferenceDescriptor)))
                throw new JCodingDescriptorValidationException("Wrong return type in annotation method '" + getName() + "': " + fullClassName);
        }
        if (getReturnTypeDescriptor() == null)
            throw new JCodingDescriptorValidationException("Annotation method '" + getName() + "' must return a value");
    }

    public JValueDescriptor getDefaultValue() {
        return defaultValue;
    }

    void setDefaultValue(JValueDescriptor defaultValue) {
        this.defaultValue = defaultValue;
    }
}
