package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JNamedBuilder;

import java.util.function.Function;

@Slf4j
public final class JTypeReferenceBuilder extends JNamedBuilder<JTypeReferenceData> {
    public JTypeReferenceBuilder(String name) {
        super(JTypeReferenceData.class, name);
    }

    public JTypeReferenceBuilder inPackage(String name) {
        return inPackage(name, x -> x);
    }

    public JTypeReferenceBuilder inPackage(String name, Function<JPackageReferenceBuilder, JPackageReferenceBuilder> func) {
        final var builder = func.apply(new JPackageReferenceBuilder(name));
        log.trace("Set package of type reference " + data.getName() + " to " + builder.build());
        data.setPackageReference(builder.build());

        return this;
    }
}
