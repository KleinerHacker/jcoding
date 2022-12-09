package org.pcsoft.framework.jcoding.core.data;

import org.pcsoft.framework.jcoding.core.data.base.JNamedBuilder;

public final class JParameterReferenceBuilder extends JNamedBuilder<JParameterReferenceData> {
    public JParameterReferenceBuilder(String name) {
        super(JParameterReferenceData.class, name);
    }

    public JParameterReferenceBuilder withValue(Object value) {
        data.setValue(value);
        return this;
    }
}
