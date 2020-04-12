package org.hamcrest.visibility;

import org.hamcrest.Matcher;

import java.lang.reflect.Member;

public class IsPrivate<T> extends AbstractVisibilityMatcher<T>
{
    public IsPrivate(){
        super(VisibilityUtils.PRIVATE_DESCRIPTION);
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
            return VisibilityUtils.isPrivate((Class<?>) actual);
        }
        if (actual instanceof Member)
        {
            return VisibilityUtils.isPrivate((Member) actual);
        }
        return false;
    }

    public static <T> Matcher<T> isPrivate()
    {
        return new IsPrivate<>();
    }
}
