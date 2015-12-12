package org.pcsoft.framework.jcoding.jobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Base implementation for a parametrized method
 */
public abstract class JParametrizedMethodDescriptor extends JMethodDescriptor {
    private final List<JParameterDescriptor> parameterList = new ArrayList<>();

    public JParameterDescriptor[] getParameters() {
        return parameterList.toArray(new JParameterDescriptor[parameterList.size()]);
    }

    void addParameter(final JParameterDescriptor parameterDescriptor) {
        //TODO: BiBinding
        parameterList.add(parameterDescriptor);
    }

    void removeParameter(final JParameterDescriptor parameterDescriptor) {
        //TODO: BiBinding
        parameterList.remove(parameterDescriptor);
    }
}
