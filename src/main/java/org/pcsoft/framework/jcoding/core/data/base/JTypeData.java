package org.pcsoft.framework.jcoding.core.data.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class JTypeData extends JMemberData {
    private final List<JMemberData> members = new ArrayList<>();
}
