package com.thoughtworks.cschuyle.util;

public class ClassHelpers {

    private ClassHelpers() {}

    public static String simpleName( Object object ) {
        final Class<?> objectClass = object.getClass();
        return objectClass.getSimpleName();
    }
}
