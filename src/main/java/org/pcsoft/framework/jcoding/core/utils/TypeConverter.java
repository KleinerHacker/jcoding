package org.pcsoft.framework.jcoding.core.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceBuilder;
import org.pcsoft.framework.jcoding.core.data.JTypeReferenceData;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TypeConverter {

    public static JTypeReferenceData toTypeReference(Class<?> type) {
        if (type.isPrimitive())
            return new JTypeReferenceBuilder(type.getSimpleName()).build();

        return new JTypeReferenceBuilder(type.getSimpleName())
                .inPackage(type.getPackageName())
                .build();
    }

}
