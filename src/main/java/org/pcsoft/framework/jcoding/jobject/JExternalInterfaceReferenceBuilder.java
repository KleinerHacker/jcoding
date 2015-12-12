package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JExternalInterfaceReferenceBuilder extends JExternalTypeReferenceBuilder<JExternalInterfaceReferenceDescriptor, JExternalInterfaceReferenceBuilder> implements JInterfaceReferenceBuilder<JExternalInterfaceReferenceDescriptor>{
    public static JExternalInterfaceReferenceBuilder create(String fullClassName) {
        return new JExternalInterfaceReferenceBuilder().withReferenceFullClassName(fullClassName);
    }

    public static JExternalInterfaceReferenceBuilder create(Class referenceClass) {
        return new JExternalInterfaceReferenceBuilder().withReferenceFullClassName(referenceClass);
    }

    private JExternalInterfaceReferenceBuilder() {
        super(JExternalInterfaceReferenceDescriptor.class);
    }
}
