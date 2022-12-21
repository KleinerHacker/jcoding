package org.pcsoft.framework.jcoding.core.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.data.base.JAnnotatableData;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class JParameterData extends JAnnotatableData {
    private boolean isFinal;
    private JTypeReferenceData type;
}
