package org.pcsoft.framework.jcoding.core.data;

import lombok.*;
import org.pcsoft.framework.jcoding.core.data.base.JData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
public final class JAnnotationReferenceData extends JData {
    @EqualsAndHashCode.Include
    private JTypeReferenceData type;

    private final List<JParameterReferenceData> parameterReferences = new ArrayList<>();

    public JAnnotationReferenceData(JTypeReferenceData type, JParameterReferenceData[] parameterReferences) {
        this.type = type;
        this.parameterReferences.addAll(Arrays.asList(parameterReferences));
    }
}
