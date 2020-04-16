package org.hamcrest.visibility;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.lang.reflect.Member;

/**
 * Matches the visibility of a reflective element, like a {@link Class} or a {@link java.lang.reflect.Method},
 * to make assertions about the scope of a module's API.
 *
 * @param <T> the type of the element being matched; could be anything
 * @see VisibilityMatchers
 */
class VisibilityMatcher<T> extends BaseMatcher<T>
{
    private final Visibility expectedVisibility;

    VisibilityMatcher(Visibility expectedVisibility)
    {
        this.expectedVisibility = expectedVisibility;
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
            return expectedVisibility == VisibilityUtils.getVisibility((Class<?>) actual);
        }
        if (actual instanceof Member)
        {
            return expectedVisibility == VisibilityUtils.getVisibility((Member) actual);
        }
        return false;
    }

    @Override public void describeTo(Description description)
    {
        description.appendText("is ").appendText(expectedVisibility.getDescription());
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
                    .appendText(VisibilityUtils.getVisibility((Class<?>) item).getDescription())
                    .appendText(" class");
        }
        else if (item instanceof Member)
        {
            description.appendText("was a ")
                    .appendText(VisibilityUtils.getVisibility((Member) item).getDescription())
                    .appendText(" ")
                    .appendText(item.getClass().getName());
        }
        else
        {
            description.appendText("was " + item.getClass().getName() + " instead of a reflective element like a Class<T>, Constructor<T>, or Method");
        }
    }
}
