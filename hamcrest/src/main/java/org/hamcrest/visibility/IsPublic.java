package org.hamcrest.visibility;

import org.hamcrest.Matcher;

import java.lang.reflect.Member;

public class IsPublic<T> extends AbstractVisibilityMatcher<T>
{
    public IsPublic(){
        super(VisibilityUtils.PUBLIC_DESCRIPTION);
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
            return VisibilityUtils.isPublic((Class<?>) actual);
        }
        if (actual instanceof Member)
        {
            return VisibilityUtils.isPublic((Member) actual);
        }
        return false;
    }

    public static <T> Matcher<T> isPublic()
    {
        return new IsPublic<>();
    }
}
