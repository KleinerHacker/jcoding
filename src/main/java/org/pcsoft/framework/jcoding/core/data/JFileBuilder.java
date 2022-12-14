package org.pcsoft.framework.jcoding.core.data;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.base.JNamedBuilder;

import java.util.function.Function;

@Slf4j
public final class JFileBuilder extends JNamedBuilder<JFileData> {
    public JFileBuilder(String name) {
        super(JFileData.class, name);
    }

    public JFileBuilder inPackage(String name) {
        return inPackage(name, x -> x);
    }

    public JFileBuilder inPackage(String name, Function<JPackageBuilder, JPackageBuilder> func) {
        final var builder = func.apply(new JPackageBuilder(name));
        log.trace("Set package of file " + name + " to " + builder.build());
        data.setPackageData(builder.build());

        return this;
    }

    public JFileBuilder withClass(String name, Function<JClassBuilder, JClassBuilder> func) {
        final var builder = func.apply(new JClassBuilder(name));
        log.trace("Add class to file " + name + ": " + builder.build());
        data.getTypes().add(builder.build());

        return this;
    }

    public JFileBuilder withInterface(String name, Function<JInterfaceBuilder, JInterfaceBuilder> func) {
        final var builder = func.apply(new JInterfaceBuilder(name));
        log.trace("Add interface to file " + name + ": " + builder.build());
        data.getTypes().add(builder.build());

        return this;
    }

    public JFileBuilder withEnumeration(String name, Function<JEnumerationBuilder, JEnumerationBuilder> func) {
        final var builder = func.apply(new JEnumerationBuilder(name));
        log.trace("Add enumeration to file " + name + ": " + builder.build());
        data.getTypes().add(builder.build());

        return this;
    }
}
