package org.pcsoft.framework.jcoding.core.data;

import org.pcsoft.framework.jcoding.core.data.base.JNamedBuilder;

import java.util.function.Function;

public final class JTypeReferenceBuilder extends JNamedBuilder<JTypeReferenceData> {
    public JTypeReferenceBuilder(String name) {
        super(JTypeReferenceData.class, name);
    }

    public JTypeReferenceBuilder inPackage(String name) {
        return inPackage(name, x -> x);
    }

    public JTypeReferenceBuilder inPackage(String name, Function<JPackageReferenceBuilder, JPackageReferenceBuilder> func) {
        final var builder = func.apply(new JPackageReferenceBuilder(name));
        data.setPackageReference(builder.build());

        return this;
    }
}
