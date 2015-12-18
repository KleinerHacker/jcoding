package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Created by Christoph on 18.12.2015.
 */
public abstract class JExternalTypeReference extends JTypeReferenceBase {
    private final String fullReferenceClassName;

    public JExternalTypeReference(String fullReferenceClassName) {
        this.fullReferenceClassName = fullReferenceClassName;
    }

    @Override
    public String getFullClassName(JClassNamePresentation classNamePresentation) {
        switch (classNamePresentation) {
            case Canonical:
                return fullReferenceClassName.replace(CLASS_SEPARATOR, ".");
            case Documentation:
                return fullReferenceClassName.replace(CLASS_SEPARATOR, "#");
            case Reference:
                return fullReferenceClassName;
            default:
                throw new RuntimeException();
        }
    }
}
