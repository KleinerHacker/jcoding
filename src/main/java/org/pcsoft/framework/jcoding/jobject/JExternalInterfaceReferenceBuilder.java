package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JExternalInterfaceReferenceBuilder extends JExternalTypeReferenceBuilder<JExternalInterfaceReferenceDescriptor, JExternalInterfaceReferenceBuilder> implements JInterfaceReferenceBuilder<JExternalInterfaceReferenceDescriptor>{
    public static JExternalInterfaceReferenceBuilder create() {
        return new JExternalInterfaceReferenceBuilder();
    }

    public static JExternalInterfaceReferenceBuilder create(String fullClassName) {
        return create().withReferenceFullClassName(fullClassName);
    }

    public static JExternalInterfaceReferenceBuilder create(Class referenceClass) {
        return create().withReferenceFullClassName(referenceClass);
    }

    private JExternalInterfaceReferenceBuilder() {
        super(JExternalInterfaceReferenceDescriptor.class);
    }
}
