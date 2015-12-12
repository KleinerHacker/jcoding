package org.pcsoft.framework.jcoding.jobject;

/**
 * Represent an interface to mark object as child of any {@link JParent}
 */
public interface JChild {

    /**
     * Returns the parent for this object
     * @return
     */
    JParent getParent();

}
