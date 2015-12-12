package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JParameterDescriptor extends JDefinitionDescriptor {
    private boolean $final;
    private JTypeReferenceDescriptor type;

    public boolean isFinal() {
        return $final;
    }

    void setFinal(boolean $final) {
        this.$final = $final;
    }

    public JTypeReferenceDescriptor getType() {
        return type;
    }

    void setType(JTypeReferenceDescriptor type) {
        this.type = type;
    }
}
