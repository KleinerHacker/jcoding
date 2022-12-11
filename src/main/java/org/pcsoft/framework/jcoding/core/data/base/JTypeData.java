package org.pcsoft.framework.jcoding.core.data.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceData;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class JTypeData extends JAnnotatableData {
    private boolean isStatic = false;
    private JAccessModifier access = JAccessModifier.PUBLIC;

    public JTypeData(String name, JAnnotationReferenceData[] annotationReferences, boolean isStatic, JAccessModifier access) {
        super(name, annotationReferences);
        this.isStatic = isStatic;
        this.access = access;
    }
}
