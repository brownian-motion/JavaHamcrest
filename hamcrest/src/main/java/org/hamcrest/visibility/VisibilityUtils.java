package org.hamcrest.visibility;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

class VisibilityUtils
{
    private static boolean isPublic(Class<?> clazz)
    {
        return clazz != null && Modifier.isPublic(clazz.getModifiers());
    }

    private static boolean isProtected(Class<?> clazz)
    {
        return clazz != null && Modifier.isProtected(clazz.getModifiers());
    }

    private static boolean isPrivate(Class<?> clazz)
    {
        return clazz != null && Modifier.isPrivate(clazz.getModifiers());
    }


    private static boolean isPublic(Member member)
    {
        return member != null && Modifier.isPublic(member.getModifiers());
    }

    private static boolean isProtected(Member member)
    {
        return member != null && Modifier.isProtected(member.getModifiers());
    }

    private static boolean isPrivate(Member member)
    {
        return member != null && Modifier.isPrivate(member.getModifiers());
    }

    static Visibility getVisibility(Class<?> clazz){
        if(isPublic(clazz))
            return Visibility.PUBLIC;
        if(isProtected(clazz))
            return Visibility.PROTECTED;
        if(isPrivate(clazz))
            return Visibility.PRIVATE;
        return Visibility.PACKAGE_PROTECTED;
    }

    static Visibility getVisibility(Member member){
        if(isPublic(member))
            return Visibility.PUBLIC;
        if(isProtected(member))
            return Visibility.PROTECTED;
        if(isPrivate(member))
            return Visibility.PRIVATE;
        return Visibility.PACKAGE_PROTECTED;
    }
}
