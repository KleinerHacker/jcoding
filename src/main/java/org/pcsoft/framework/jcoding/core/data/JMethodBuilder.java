package org.pcsoft.framework.jcoding.core.data;

import org.pcsoft.framework.jcoding.core.data.base.JMemberBuilder;

import java.util.function.Function;

public final class JMethodBuilder extends JMemberBuilder<JMethodData, JMethodBuilder> {
    public JMethodBuilder(String name) {
        super(JMethodData.class, name);
    }

    public JMethodBuilder isFinal() {
        data.setFinal(true);
        return this;
    }

    public JMethodBuilder isAbstract() {
        data.setAbstract(true);
        return this;
    }

    public JMethodBuilder withReturnType(Class<?> type) {
        return withReturnType(type.getSimpleName(), x -> x.inPackage(type.getPackageName()));
    }

    public JMethodBuilder withReturnType(String name, Function<JTypeReferenceBuilder, JTypeReferenceBuilder> func) {
        data.setReturnType(func.apply(new JTypeReferenceBuilder(name)).build());
        return this;
    }
}
