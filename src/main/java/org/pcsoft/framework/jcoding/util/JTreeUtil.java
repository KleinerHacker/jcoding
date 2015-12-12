package org.pcsoft.framework.jcoding.util;

import org.pcsoft.framework.jcoding.jobject.JChild;
import org.pcsoft.framework.jcoding.jobject.JParent;

/**
 * Tree Utils for the descriptor tree
 */
public final class JTreeUtil {

    /**
     * Returns the parent of given type for the given child in soft mode
     * @param child Child to search from
     * @param parentClass Class of parent to find
     * @param <T>
     * @return The parent of the child or NULL if no parent was found.
     */
    public static <T extends JParent>T getParentOfType(final JChild child, final Class<T> parentClass) {
        return getParentOfType(child, parentClass, false);
    }

    /**
     * Returns the parent of given type for the given child
     * @param child Child to search from
     * @param parentClass Class of parent to find
     * @param strict TRUE to do a strict equality (==), otherwise FALSE (isAssignableFrom)
     * @param <T>
     * @return The parent of the child or NULL if no parent was found.
     */
    public static <T extends JParent>T getParentOfType(final JChild child, final Class<T> parentClass, final boolean strict) {
        T currentDescriptor = (T)child.getParent();
        while (currentDescriptor != null) {
            if (strict) {
                if (currentDescriptor.getClass() == parentClass)
                    return currentDescriptor;
            } else {
                if (parentClass.isAssignableFrom(currentDescriptor.getClass()))
                    return currentDescriptor;
            }

            if (!(currentDescriptor instanceof JChild))
                break;
            currentDescriptor = (T)((JChild) currentDescriptor).getParent();
        }

        return null;
    }

    private JTreeUtil() {
    }
}
