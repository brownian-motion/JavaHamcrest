package org.hamcrest.visibility;

public enum Visibility
{
    PUBLIC("public"),
    PROTECTED("protected"),
    PACKAGE_PROTECTED("package-protected (no modifiers)"),
    PRIVATE("private");

    public String getDescription()
    {
        return description;
    }

    private final String description;

    Visibility(String description){
        this.description = description;
    }
}
