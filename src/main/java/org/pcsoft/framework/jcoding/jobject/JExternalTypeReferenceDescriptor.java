package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Created by Christoph on 12.12.2015.
 */
public abstract class JExternalTypeReferenceDescriptor extends JTypeReferenceDescriptor {
    private static final String CLASS_SEPARATOR = "$";

    private String fullReferenceClassName;

    public String getFullReferenceClassName() {
        return fullReferenceClassName;
    }

    public void setFullReferenceClassName(String fullReferenceClassName) {
        this.fullReferenceClassName = fullReferenceClassName;
    }

    @Override
    public String getFullClassName(JClassNamePresentation presentation) {
        switch (presentation) {
            case Canonical:
                return fullReferenceClassName.replace(CLASS_SEPARATOR, ".");
            case Documentation:
                return fullReferenceClassName.replace(CLASS_SEPARATOR, "#");
            case Reference:
                return fullReferenceClassName;
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (fullReferenceClassName == null)
            throw new JCodingDescriptorValidationException("Reference class name not set!");
    }
}
