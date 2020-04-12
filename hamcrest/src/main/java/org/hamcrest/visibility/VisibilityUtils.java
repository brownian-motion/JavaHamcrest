package org.hamcrest.visibility;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

class VisibilityUtils
{

    static final String PUBLIC_DESCRIPTION = "public";
    static final String PROTECTED_DESCRIPTION = "protected";
    static final String PACKAGE_PROTECTED_DESCRIPTION = "package-protected (no modifiers)";
    static final String PRIVATE_DESCRIPTION = "private";

    static boolean isPublic(Class<?> clazz)
    {
        return clazz != null && Modifier.isPublic(clazz.getModifiers());
    }

    static boolean isProtected(Class<?> clazz)
    {
        return clazz != null && Modifier.isProtected(clazz.getModifiers());
    }

    static boolean isPackageProtected(Class<?> clazz)
    {
        return clazz != null && !isPublic(clazz) && !isProtected(clazz) && !isPrivate(clazz);
    }

    static boolean isPrivate(Class<?> clazz)
    {
        return clazz != null && Modifier.isPrivate(clazz.getModifiers());
    }


    static boolean isPublic(Member member)
    {
        return member != null && Modifier.isPublic(member.getModifiers());
    }

    static boolean isProtected(Member member)
    {
        return member != null && Modifier.isProtected(member.getModifiers());
    }

    static boolean isPackageProtected(Member member)
    {
        return member != null && !isPublic(member) && !isProtected(member) && !isPrivate(member);
    }

    static boolean isPrivate(Member member)
    {
        return member != null && Modifier.isPrivate(member.getModifiers());
    }


    static String describeVisibility(Class<?> clazz)
    {
        if (isPublic(clazz))
        {
            return PUBLIC_DESCRIPTION;
        }
        if (isProtected(clazz))
        {
            return PROTECTED_DESCRIPTION;
        }
        if (isPackageProtected(clazz))
        {
            return PACKAGE_PROTECTED_DESCRIPTION;
        }
        if (isPrivate(clazz))
        {
            return PRIVATE_DESCRIPTION;
        }
        throw new IllegalArgumentException("Encountered unexpected visibility! This should NEVER happen.");
    }

    static String describeVisibility(Member member)
    {
        if (isPublic(member))
        {
            return PUBLIC_DESCRIPTION;
        }
        if (isProtected(member))
        {
            return PROTECTED_DESCRIPTION;
        }
        if (isPackageProtected(member))
        {
            return PACKAGE_PROTECTED_DESCRIPTION;
        }
        if (isPrivate(member))
        {
            return PRIVATE_DESCRIPTION;
        }
        throw new IllegalArgumentException("Encountered unexpected visibility! This should NEVER happen.");
    }
}
