package org.pcsoft.framework.jcoding.core.data;

import org.pcsoft.framework.jcoding.core.data.base.JAnnotatableBuilder;

public final class JPackageBuilder extends JAnnotatableBuilder<JPackageData, JPackageBuilder> {
    public JPackageBuilder(String name) {
        super(JPackageData.class, name);
    }
}
