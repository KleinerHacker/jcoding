package org.pcsoft.framework.jcoding.type;

/**
 * Supported Numbers
 */
public enum JNumberType {
    Byte(Byte.class, null),
    Short(Short.class, null),
    Integer(Integer.class, ""),
    Long(Long.class, "l"),
    Double(Double.class, "d"),
    Float(Float.class, "f");

    private final Class<? extends Number> numberClass;
    private final String numberIndicator;

    private JNumberType(Class<? extends Number> numberClass, String numberIndicator) {
        this.numberClass = numberClass;
        this.numberIndicator = numberIndicator;
    }

    /**
     * Returns the Java Class for this number
     * @return
     */
    public Class<? extends Number> getNumberClass() {
        return numberClass;
    }

    /**
     * Returns a String as indicator (like 9.1f or .3d) or NULL if no indicator exists (must be cast, like short or byte)
     * @return
     */
    public String getNumberIndicator() {
        return numberIndicator;
    }
}
