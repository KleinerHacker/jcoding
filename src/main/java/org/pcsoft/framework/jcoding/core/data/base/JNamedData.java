package org.pcsoft.framework.jcoding.core.data.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
public abstract class JNamedData extends JData {
    @EqualsAndHashCode.Include
    private String name;

    protected JNamedData(String name) {
        this.name = name;
    }
}
