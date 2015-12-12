package org.pcsoft.framework.jcoding.management;

import org.apache.commons.lang.SystemUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the import manager to handle all imports for a java file.
 */
public final class ImportManagement {
    private final List<String> fullClassNameList = new ArrayList<>();

    public ImportManagement() {
    }

    public String buildImportList() {
        final StringBuilder sb = new StringBuilder();
        for (final String fullClassName : fullClassNameList) {
            sb.append("import ").append(fullClassName).append(";").append(SystemUtils.LINE_SEPARATOR);
        }

        return sb.toString();
    }

    public String get(int index) {
        return fullClassNameList.get(index);
    }

    public boolean add(String s) {
        if (s == null)
            return false;
        if (fullClassNameList.contains(s))
            return false;

        return fullClassNameList.add(s);
    }

    public int size() {
        return fullClassNameList.size();
    }

    public boolean remove(String s) {
        return fullClassNameList.remove(s);
    }

//    public boolean replace(String oldValue, String newValue) {
//        if (newValue == null)
//            throw new IllegalArgumentException("new value must be set");
//
//        final boolean result;
//        if (oldValue != null && fullClassNameList.contains(oldValue)) {
//            fullClassNameList.remove(oldValue);
//            result = true;
//        } else {
//            result = false;
//        }
//
//        fullClassNameList.add(newValue);
//        return result;
//    }
}
