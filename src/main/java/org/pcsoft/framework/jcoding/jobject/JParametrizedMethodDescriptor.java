package org.pcsoft.framework.jcoding.jobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Base implementation for a parametrized method
 */
public abstract class JParametrizedMethodDescriptor extends JMethodDescriptor {
    private final List<JParameterDescriptor> parameterList = new ArrayList<>();
    private final List<JGenericDescriptor> genericList = new ArrayList<>();

    public JParameterDescriptor[] getParameters() {
        return parameterList.toArray(new JParameterDescriptor[parameterList.size()]);
    }

    public void addParameter(final JParameterDescriptor parameterDescriptor) {
        //TODO: BiBinding
        parameterList.add(parameterDescriptor);
    }

    public void removeParameter(final JParameterDescriptor parameterDescriptor) {
        //TODO: BiBinding
        parameterList.remove(parameterDescriptor);
    }

    public JGenericDescriptor[] getGenerics() {
        return genericList.toArray(new JGenericDescriptor[genericList.size()]);
    }

    public void addGeneric(final JGenericDescriptor generic) {
        genericList.add(generic);
    }

    public void removeGeneric(final JGenericDescriptor generic) {
        genericList.remove(generic);
    }
}
