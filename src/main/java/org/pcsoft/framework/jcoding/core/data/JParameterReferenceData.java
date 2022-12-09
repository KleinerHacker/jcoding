package org.pcsoft.framework.jcoding.core.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.data.base.JNamedData;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class JParameterReferenceData extends JNamedData {
    private Object value;

    public JParameterReferenceData(String name, Object value) {
        super(name);
        this.value = value;
    }
}
