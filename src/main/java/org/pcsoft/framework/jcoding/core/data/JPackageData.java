package org.pcsoft.framework.jcoding.core.data;

import lombok.NoArgsConstructor;
import org.pcsoft.framework.jcoding.core.data.base.JAnnotatableData;

@NoArgsConstructor
public final class JPackageData extends JAnnotatableData {
    public JPackageData(String name, JAnnotationReferenceData[] annotationReferences) {
        super(name, annotationReferences);
    }
}
