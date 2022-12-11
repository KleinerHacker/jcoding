package org.pcsoft.framework.jcoding.core.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum JAccessModifier {
    PUBLIC("public"),
    PACKAGE_INTERNAL(""),
    PROTECTED("protected"),
    PRIVATE("private"),
    ;

    private final String modifier;
}
