package org.pcsoft.framework.jcoding.type;

/**
 * Enumeration how to show the full class name
 */
public enum JClassNamePresentation {
    /**
     * Class name is shown with points only, for sub classes too
     */
    Canonical('.'),
    /**
     * Class name is shown with points and '$', for sub classes
     */
    Reference('$'),
    /**
     * Class name is shown with points and '#', for sub classes
     */
    Documentation('#')
    ;

    private final char concatenationCharacter;

    private JClassNamePresentation(char concatenationCharacter) {
        this.concatenationCharacter = concatenationCharacter;
    }

    public char getConcatenationCharacter() {
        return concatenationCharacter;
    }
}
