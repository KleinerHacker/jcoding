package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingBuilderException;

/**
 * Represent the java file builder to create (as base) a java file, see {@link JFileDescriptor}.
 */
public final class JFileBuilder extends JObjectBuilderBase<JFileDescriptor> {

    public static JFileBuilder create() {
        return new JFileBuilder();
    }

    /**
     * Creates a java file builder with given filename as initial value.
     * @param filename
     * @return
     */
    public static JFileBuilder create(final String filename) {
        return create().withFilename(filename);
    }

    private JFileBuilder() {
        super(JFileDescriptor.class);
    }

    public JFileBuilder withFilename(final String filename) {
        value.setFilename(filename);
        return this;
    }

    public JFileBuilder withPackage(final String packageName) {
        value.setPackageName(packageName);
        return this;
    }

    public JFileBuilder withJavaType(final JTypeBuilder typeBuilder) throws JCodingBuilderException {
        return withJavaType((JTypeDescriptor) typeBuilder.build());
    }

    public JFileBuilder withJavaType(final JTypeDescriptor typeDescriptor) {
        value.addJavaType(typeDescriptor);
        return this;
    }

    public JFileBuilder withJavaTypes(final JTypeBuilder... typeBuilders) throws JCodingBuilderException {
        for (final JTypeBuilder typeBuilder : typeBuilders) {
            value.addJavaType((JTypeDescriptor) typeBuilder.build());
        }
        return this;
    }

    public JFileBuilder withJavaTypes(final JTypeDescriptor... typeDescriptors) {
        for (final JTypeDescriptor typeDescriptor : typeDescriptors) {
            value.addJavaType(typeDescriptor);
        }
        return this;
    }
}
