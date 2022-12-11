package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JNamedBuilder;

@Slf4j
public final class JParameterReferenceBuilder extends JNamedBuilder<JParameterReferenceData> {
    public JParameterReferenceBuilder(String name) {
        super(JParameterReferenceData.class, name);
    }

    public JParameterReferenceBuilder withValue(Object value) {
        data.setValue(value);
        log.trace("Set value of parameter reference " + data.getName() + " to " + value);
        return this;
    }
}
