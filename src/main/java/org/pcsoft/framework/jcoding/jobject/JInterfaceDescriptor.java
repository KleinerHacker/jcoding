package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;

import java.util.stream.Stream;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JInterfaceDescriptor extends JInheritableTypeDescriptor {

    JInterfaceDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        super.validate();

        if (Stream.of(getFields()).anyMatch(item -> !item.isStatic()))
            throw new JCodingDescriptorValidationException("Found non static fields in interface: " + getName());
    }
}
