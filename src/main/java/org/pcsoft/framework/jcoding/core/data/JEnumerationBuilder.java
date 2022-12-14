package org.pcsoft.framework.jcoding.core.data;

import org.pcsoft.framework.jcoding.core.data.base.JTypeBuilder;

public final class JEnumerationBuilder extends JTypeBuilder<JEnumerationData, JEnumerationBuilder> {
    public JEnumerationBuilder(String name) {
        super(JEnumerationData.class, name);
    }
}
