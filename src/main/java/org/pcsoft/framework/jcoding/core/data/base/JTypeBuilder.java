package org.pcsoft.framework.jcoding.core.data.base;

import lombok.extern.slf4j.Slf4j;
import org.pcsoft.framework.jcoding.core.data.*;

import java.util.function.Function;

@SuppressWarnings("unchecked")
@Slf4j
public abstract class JTypeBuilder<T extends JTypeData, B extends JTypeBuilder<T,B>> extends JMemberBuilder<T,B> {
    protected JTypeBuilder(Class<T> dataClass, String name) {
        super(dataClass, name);
    }

    public B withClass(String name, Function<JClassBuilder, JClassBuilder> func) {
        final var builder = func.apply(new JClassBuilder(name));
        log.trace("Add class to type " + name + ": " + builder.build());
        data.getMembers().add(builder.build());

        return (B) this;
    }

    public B withInterface(String name, Function<JInterfaceBuilder, JInterfaceBuilder> func) {
        final var builder = func.apply(new JInterfaceBuilder(name));
        log.trace("Add interface to type " + name + ": " + builder.build());
        data.getMembers().add(builder.build());

        return (B) this;
    }

    public B withEnumeration(String name, Function<JEnumerationBuilder, JEnumerationBuilder> func) {
        final var builder = func.apply(new JEnumerationBuilder(name));
        log.trace("Add enumeration to type " + name + ": " + builder.build());
        data.getMembers().add(builder.build());

        return (B) this;
    }

    public B withMethod(String name, Function<JMethodBuilder, JMethodBuilder> func) {
        final var builder = func.apply(new JMethodBuilder(name));
        log.trace("Add method to type " + name + ": " + builder.build());
        data.getMembers().add(builder.build());

        return (B) this;
    }

    public B withField(String name, Function<JFieldBuilder, JFieldBuilder> func) {
        final var builder = func.apply(new JFieldBuilder(name));
        log.trace("Add field to type " + name + ": " + builder.build());
        data.getMembers().add(builder.build());

        return (B) this;
    }
}
