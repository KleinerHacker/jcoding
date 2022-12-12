package org.pcsoft.framework.jcoding.core.data;

import lombok.*;
import org.pcsoft.framework.jcoding.core.data.base.JNamedData;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public final class JTypeReferenceData extends JNamedData {
    @EqualsAndHashCode.Include
    private JPackageReferenceData packageReference;

}
