package org.pcsoft.framework.jcoding.jobject;

import org.pcsoft.framework.jcoding.exception.JCodingDescriptorValidationException;
import org.pcsoft.framework.jcoding.type.JVisibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a java file descriptor (as base). Generate this object with {@link JFileBuilder}.
 */
public final class JFileDescriptor extends JObjectDescriptorBase implements JParent {
    private String filename;
    private String packageName;

    private final List<JTypeDescriptor> classDescriptorList = new ArrayList<>();

    @Override
    public void validate() throws JCodingDescriptorValidationException {
        if (filename == null)
            throw new JCodingDescriptorValidationException("Code filename is not set!");
        if (!classDescriptorList.isEmpty()) {
            if (classDescriptorList.size() > 1) {
                if (classDescriptorList.parallelStream()
                        .filter(item -> item.getVisibility() == JVisibility.Public)
                        .count() != 1)
                    throw new JCodingDescriptorValidationException("No ore more than one root class for code file '" + filename + "' was found!");
                if (classDescriptorList.parallelStream()
                        .anyMatch(item -> item.getVisibility() == JVisibility.Private || item.getVisibility() == JVisibility.PackageInternal))
                    throw new JCodingDescriptorValidationException("Found classes with illegal visibility in code file '" + filename + "'!");
            }
        }
    }

    public String getFilename() {
        return filename;
    }

    void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPackageName() {
        return packageName;
    }

    void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public JTypeDescriptor[] getTypeDescriptors() {
        return classDescriptorList.toArray(new JTypeDescriptor[classDescriptorList.size()]);
    }

    void addJavaType(final JTypeDescriptor typeDescriptor) {
        typeDescriptor.setParent(this);
        classDescriptorList.add(typeDescriptor);
    }

    void removeJavaType(final JTypeDescriptor typeDescriptor) {
        typeDescriptor.setParent(null);
        classDescriptorList.remove(typeDescriptor);
    }
}
