package org.pcsoft.framework.jcoding.core.data;

import org.pcsoft.framework.jcoding.core.data.base.JBuilder;

import java.util.function.Function;

public final class JFileBuilder extends JBuilder<JFileData> {
    public JFileBuilder() {
        super(JFileData.class);
    }

    public JFileBuilder inPackage(String name) {
        return inPackage(name, x -> x);
    }

    public JFileBuilder inPackage(String name, Function<JPackageBuilder, JPackageBuilder> func) {
        final var builder = func.apply(new JPackageBuilder(name));
        data.setPackageData(builder.build());

        return this;
    }
}
