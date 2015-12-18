package org.pcsoft.framework.jcoding.type;

/**
 * Enumeration with all known visibility types
 */
public enum JVisibility {
    Public("public"),
    PackageInternal(""),
    Default(""),
    Protected("protected"),
    Private("private");

    private final String keyword;

    private JVisibility(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
