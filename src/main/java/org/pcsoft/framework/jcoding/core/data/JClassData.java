package org.pcsoft.framework.jcoding.core.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class JClassData extends JTypeData {
    private boolean isAbstract;

    public JClassData(String name, JAnnotationReferenceData[] annotationReferences, boolean $static, JAccessModifier access, boolean isAbstract) {
        super(name, annotationReferences, $static, access);
        this.isAbstract = isAbstract;
    }
}
