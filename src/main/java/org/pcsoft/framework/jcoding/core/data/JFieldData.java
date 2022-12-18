package org.pcsoft.framework.jcoding.core.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.data.base.JMemberData;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class JFieldData extends JMemberData {
    private boolean isFinal = false;
    private JTypeReferenceData type;
    private boolean hasDirectInitialization = false;
    private Object value;
}
