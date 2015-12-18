package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public final class JParameterDescriptor extends JDefinitionDescriptor {
    private boolean $final;
    private JReferenceDescriptor reference;

    public boolean isFinal() {
        return $final;
    }

    public void setFinal(boolean $final) {
        this.$final = $final;
    }

    public JReferenceDescriptor getReference() {
        return reference;
    }

    public void setReference(JReferenceDescriptor reference) {
        this.reference = reference;
    }
}
