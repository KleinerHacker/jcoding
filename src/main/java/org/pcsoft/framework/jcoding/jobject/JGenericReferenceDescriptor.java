package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

/**
 * Represent a generic reference, based on a {@link JGenericDescriptor}
 */
public final class JGenericReferenceDescriptor extends JReferenceDescriptor {
    private JGenericDescriptor genericReference;

    public JGenericDescriptor getGenericReference() {
        return genericReference;
    }

    public void setGenericReference(JGenericDescriptor genericReference) {
        this.genericReference = genericReference;
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (genericReference == null)
            throw new JCodingDescriptorValidationException("Generic Reference not set!");
    }
}
