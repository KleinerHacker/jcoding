package org.pcsoft.framework.jcoding.jobject.type;

import org.pcsoft.framework.jcoding.jobject.JFileDescriptor;
import org.pcsoft.framework.jcoding.jobject.JParent;
import org.pcsoft.framework.jcoding.jobject.JTypeDescriptor;
import org.pcsoft.framework.jcoding.type.JClassNamePresentation;

/**
 * Created by Christoph on 18.12.2015.
 */
public abstract class JInternalTypeReference<T extends JTypeDescriptor> extends JTypeReferenceBase {

    private final T typeReference;

    public JInternalTypeReference(T typeReference) {
        this.typeReference = typeReference;
    }

    public T getTypeReference() {
        return typeReference;
    }

    @Override
    public final String getFullClassName(JClassNamePresentation classNamePresentation) {
        String fullClassName = typeReference.getName();

        JParent currentParent = typeReference.getParent();
        while (currentParent != null) {
            if (currentParent instanceof JTypeDescriptor) {
                //Sub Class
                fullClassName = ((JTypeDescriptor) currentParent).getName() +
                        classNamePresentation.getConcatenationCharacter() + fullClassName;
                currentParent = ((JTypeDescriptor) currentParent).getParent();
            } else if (currentParent instanceof JFileDescriptor) {
                //Root Class
                fullClassName = ((JFileDescriptor) currentParent).getPackageName() + "." + fullClassName;
                break;
            } else
                throw new RuntimeException("Unknown parent class: " + currentParent.getClass());
        }

        return fullClassName;
    }
}
