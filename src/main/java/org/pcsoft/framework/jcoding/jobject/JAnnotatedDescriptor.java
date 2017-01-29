package org.pcsoft.framework.jcoding.jobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the base implementation of an annotated element descriptor. See
 */
public abstract class JAnnotatedDescriptor extends JObjectDescriptorBase {
    private final List<JAnnotationReferenceDescriptor> annotationList = new ArrayList<>();

    public JAnnotatedDescriptor() {
    }

    /**
     * Returns the list of all annotation reference descriptors
     * @return
     */
    public List<JAnnotationReferenceDescriptor> getAnnotationList() {
        return annotationList;
    }
}
