package org.pcsoft.framework.jcoding.jobject;

import org.apache.commons.lang.ClassUtils;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Represent the descriptor for a java type reference base to use e. g. for parameters or field declarations.
 */
public abstract class JTypeReferenceDescriptorBase extends JReferenceDescriptorBase implements JTypeReferenceDescriptor {

    @Override
    public String getFullClassName() {
        return getFullClassName(JClassNamePresentation.Canonical);
    }

    @Override
    public String getSimpleClassName() {
        final String fullClassName = getFullClassName();
        if (fullClassName == null)
            return null;

        return ClassUtils.getShortClassName(fullClassName);
    }

    @Override
    public String getPackageName() {
        return ClassUtils.getPackageName(getFullClassName());
    }
}
