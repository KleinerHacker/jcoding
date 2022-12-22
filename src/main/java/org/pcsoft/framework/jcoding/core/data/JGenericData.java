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
public final class JGenericData extends JNamedData {
    private JTypeReferenceData extendsType;
    private JTypeReferenceData superType;
}
