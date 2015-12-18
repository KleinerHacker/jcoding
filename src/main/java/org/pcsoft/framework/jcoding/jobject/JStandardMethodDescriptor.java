package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JVisibility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JStandardMethodDescriptor extends JParametrizedMethodDescriptor {
    private JMethodBodyDescriptor body;
    private boolean $static;
    private final List<JClassReferenceDescriptor> throwList = new ArrayList<>();

    JStandardMethodDescriptor() {
    }

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        super.validate();
        if (isAbstract() && getVisibility() == JVisibility.Private)
            throw new JCodingDescriptorValidationException("Method '" + getName() + "' cannot be abstract and private!");
        if (isAbstract() && $static)
            throw new JCodingDescriptorValidationException("Method '" + getName() + "' cannot be abstract and static!");
        if ($static && getReturnTypeDescriptor() instanceof JGenericReferenceDescriptor) {
            final long count = Stream.of(getGenerics())
                    .filter(item -> item.getName().equals(((JGenericReferenceDescriptor) getReturnTypeDescriptor()).getGenericReference().getName()))
                    .count();
            if (count <= 0)
                throw new JCodingDescriptorValidationException("Static Method '" + getName() + "' has generic return value that is not a generic of this method!");
        }
        for (final JClassReferenceDescriptor $throw : throwList) {
            if ($throw.getGenerics().length > 0)
                throw new JCodingDescriptorValidationException("Exception '" + $throw.getSimpleClassName() + "' in throw list of method '" + getName() + "' has generics!");
            try {
                final Class<?> aClass = Class.forName($throw.getFullClassName());
                if (aClass != null && !(Throwable.class.isAssignableFrom(aClass)))
                    throw new JCodingDescriptorValidationException("Throw class '" + $throw.getSimpleClassName() +
                            "' of method '" + getName() + "' is not inherited from " + Throwable.class.getName());
            } catch (ClassNotFoundException e) {
                //Do nothing
            }
        }
    }

    public JClassReferenceDescriptor[] getThrows() {
        return throwList.toArray(new JClassReferenceDescriptor[throwList.size()]);
    }

    public void addThrow(final JClassReferenceDescriptor $throw) {
        //TODO: Parent
        throwList.add($throw);
    }

    public void removeThrow(final JClassReferenceDescriptor $throw) {
        //TODO: Parent
        throwList.remove($throw);
    }

    public boolean isAbstract() {
        return body == null;
    }

    public JMethodBodyDescriptor getBody() {
        return body;
    }

    public void setBody(JMethodBodyDescriptor body) {
        this.body = body;
    }

    public boolean isStatic() {
        return $static;
    }

    public void setStatic(boolean $static) {
        this.$static = $static;
    }
}
