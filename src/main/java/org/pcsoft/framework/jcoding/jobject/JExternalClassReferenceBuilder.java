package org.pcsoft.framework.jcoding.jobject;

/**
 * Created by Christoph on 12.12.2015.
 */
public final class JExternalClassReferenceBuilder extends JExternalTypeReferenceBuilder<JExternalClassReferenceDescriptor, JExternalClassReferenceBuilder> implements JClassReferenceBuilder<JExternalClassReferenceDescriptor>{
    public static JExternalClassReferenceBuilder create(String fullClassName) {
        return new JExternalClassReferenceBuilder().withReferenceFullClassName(fullClassName);
    }

    public static JExternalClassReferenceBuilder create(Class referenceClass) {
        return new JExternalClassReferenceBuilder().withReferenceFullClassName(referenceClass);
    }

    private JExternalClassReferenceBuilder() {
        super(JExternalClassReferenceDescriptor.class);
    }
}
