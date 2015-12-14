package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public interface JInterfaceReferenceBuilder<T extends JInterfaceReferenceDescriptor> extends JObjectBuilder<T> {
    public static JExternalInterfaceReferenceBuilder create(String fullClassName) {
        return JExternalInterfaceReferenceBuilder.create(fullClassName);
    }

    public static JExternalInterfaceReferenceBuilder create(Class referenceClass) {
        return JExternalInterfaceReferenceBuilder.create(referenceClass);
    }

    public static JInternalInterfaceReferenceBuilder create(JInterfaceDescriptor interfaceDescriptor) {
        return JInternalInterfaceReferenceBuilder.create(interfaceDescriptor);
    }
}
