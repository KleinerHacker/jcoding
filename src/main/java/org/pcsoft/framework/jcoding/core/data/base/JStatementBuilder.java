package org.pcsoft.framework.jcoding.core.data.base;

public abstract class JStatementBuilder<T extends JStatementData> extends JBuilder<T> {
    protected JStatementBuilder(Class<T> dataClass) {
        super(dataClass);
    }
}
