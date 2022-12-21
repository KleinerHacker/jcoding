package org.pcsoft.framework.jcoding.core.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pcsoft.framework.jcoding.core.data.base.JMemberData;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public final class JMethodData extends JMemberData {
    private boolean isAbstract;
    private boolean isFinal;
    private JTypeReferenceData returnType;
    private final List<JParameterData> parameters = new ArrayList<>();
}
