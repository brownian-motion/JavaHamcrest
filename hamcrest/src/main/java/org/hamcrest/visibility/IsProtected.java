package org.hamcrest.visibility;

import org.hamcrest.Matcher;

import java.lang.reflect.Member;

public class IsProtected<T> extends AbstractVisibilityMatcher<T>
{
    public IsProtected(){
        super(VisibilityUtils.PROTECTED_DESCRIPTION);
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
            return VisibilityUtils.isProtected((Class<?>) actual);
        }
        if (actual instanceof Member)
        {
            return VisibilityUtils.isProtected((Member) actual);
        }
        return false;
    }

    public static <T> Matcher<T> isProtected()
    {
        return new IsProtected<>();
    }
}
