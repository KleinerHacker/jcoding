package org.pcsoft.framework.jcoding.core.data.base;

import lombok.*;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class JMemberData extends JAnnotatableData {
    private JAccessModifier access = JAccessModifier.PUBLIC;
    private boolean isStatic = false;
}
