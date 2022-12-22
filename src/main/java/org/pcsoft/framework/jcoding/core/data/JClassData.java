package org.pcsoft.framework.jcoding.core.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.data.base.JTypeData;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class JClassData extends JTypeData {
    private boolean isAbstract;
    private boolean isFinal;
    private JTypeReferenceData superType;
}
