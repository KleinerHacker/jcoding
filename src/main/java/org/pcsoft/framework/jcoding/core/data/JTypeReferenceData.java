package org.pcsoft.framework.jcoding.core.data;

import lombok.*;
import org.pcsoft.framework.jcoding.core.data.base.JNamedData;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public final class JTypeReferenceData extends JNamedData {
    @EqualsAndHashCode.Include
    private JPackageReferenceData packageReference;
    private final List<JTypeReferenceData> generics = new ArrayList<>();

}
