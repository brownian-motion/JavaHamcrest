package org.hamcrest.visibility;

import org.hamcrest.Matcher;

public class VisibilityMatchers
{
    public static <T> Matcher<T> isPublic()
    {
        return new VisibilityMatcher<>(Visibility.PUBLIC);
    }

    public static <T> Matcher<T> isProtected()
    {
        return new VisibilityMatcher<>(Visibility.PROTECTED);
    }

    public static <T> Matcher<T> isPackageProtected()
    {
        return new VisibilityMatcher<>(Visibility.PACKAGE_PROTECTED);
    }

    public static <T> Matcher<T> isPrivate()
    {
        return new VisibilityMatcher<>(Visibility.PRIVATE);
    }

}