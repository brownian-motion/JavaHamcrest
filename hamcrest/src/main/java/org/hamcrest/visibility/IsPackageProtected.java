package org.hamcrest.visibility;

import org.hamcrest.Matcher;

import java.lang.reflect.Member;

public class IsPackageProtected<T> extends AbstractVisibilityMatcher<T>
{
    public IsPackageProtected()
    {
        super(VisibilityUtils.PACKAGE_PROTECTED_DESCRIPTION);
    }

    @Override
    public boolean matches(Object actual)
    {
        if (actual == null)
        {
            return false;
        }
        if (actual instanceof Class)
        {
            return VisibilityUtils.isPackageProtected((Class<?>) actual);
        }
        if (actual instanceof Member)
        {
            return VisibilityUtils.isPackageProtected((Member) actual);
        }
        return false;
    }

    public static <T> Matcher<T> isPackageProtected()
    {
        return new IsPackageProtected<>();
    }
}
