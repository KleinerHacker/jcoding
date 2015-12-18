package org.pcsoft.framework.jcoding.jobject.type;

import org.apache.commons.lang.ClassUtils;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Base implementation for a type reference
 */
public abstract class JTypeReferenceBase implements JTypeReference {
    protected static final String CLASS_SEPARATOR = "$";

    @Override
    public final String getFullClassName() {
        return getFullClassName(JClassNamePresentation.Canonical);
    }

    @Override
    public final String getSimpleClassName() {
        return ClassUtils.getShortClassName(getFullClassName());
    }

    @Override
    public final String getPackageName() {
        return ClassUtils.getPackageName(getFullClassName());
    }
}
