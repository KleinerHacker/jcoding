package org.pcsoft.framework.jcoding.core.data.base;

import lombok.*;
import org.pcsoft.framework.jcoding.core.data.JAnnotationReferenceData;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class JAnnotatableData extends JNamedData {
    private final List<JAnnotationReferenceData> annotationReferences = new ArrayList<>();
}
