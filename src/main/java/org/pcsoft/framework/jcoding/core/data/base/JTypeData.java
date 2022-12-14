package org.pcsoft.framework.jcoding.core.data.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.type.JAccessModifier;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class JTypeData extends JAnnotatableData {
    private JAccessModifier access = JAccessModifier.PUBLIC;
}
