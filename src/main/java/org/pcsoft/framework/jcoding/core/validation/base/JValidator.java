package org.pcsoft.framework.jcoding.core.validation.base;

import org.pcsoft.framework.jcoding.core.data.base.JData;

public abstract class JValidator<T extends JData> {
    public abstract void validate(T data);
}
