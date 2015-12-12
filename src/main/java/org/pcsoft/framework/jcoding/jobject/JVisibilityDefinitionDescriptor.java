package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JVisibility;

/**
 * Created by pfeifchr on 10.12.2015.
 */
public abstract class JVisibilityDefinitionDescriptor extends JDefinitionDescriptor {
    private JVisibility visibility;

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        super.validate();
        if (visibility == null)
            throw new JCodingDescriptorValidationException("Java class visibility is not set!");
    }

    /**
     * Returns the visibility of the definition object
     * @return
     */
    public JVisibility getVisibility() {
        return visibility;
    }

    void setVisibility(JVisibility visibility) {
        this.visibility = visibility;
    }
}
