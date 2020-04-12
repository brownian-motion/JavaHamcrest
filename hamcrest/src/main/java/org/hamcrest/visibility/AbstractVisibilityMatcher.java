package org.hamcrest.visibility;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.lang.reflect.Member;

abstract class AbstractVisibilityMatcher<T> extends BaseMatcher<T>
{
    /**
     * Should only ever be one of the values returned from
     * {@link VisibilityUtils#describeVisibility(Member)} and {@link VisibilityUtils#describeVisibility(Class)}
     **/
    private final String expectedVisibility;

    AbstractVisibilityMatcher(String expectedVisibility)
    {
        this.expectedVisibility = expectedVisibility;
    }

    @Override public void describeTo(Description description)
    {
        description.appendText("is ").appendText(expectedVisibility);
    }

    @Override public void describeMismatch(Object item, Description description)
    {
        if (item == null)
        {
            description.appendText("was null");
        }
        else if (item instanceof Class)
        {
            description.appendText("was a ")
                    .appendText(VisibilityUtils.describeVisibility((Class<?>) item))
                    .appendText(" class");
        }
        else if (item instanceof Member)
        {
            description.appendText("was a ")
                    .appendText(VisibilityUtils.describeVisibility((Member) item))
                    .appendText(" ")
                    .appendText(item.getClass().getName());
        }
        else
        {
            description.appendText("was "+item.getClass().getName()+" instead of a reflective element like a Class<T>, Constructor<T>, or Method");
        }
    }
}
