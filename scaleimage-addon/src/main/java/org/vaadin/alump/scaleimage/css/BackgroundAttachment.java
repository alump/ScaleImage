package org.vaadin.alump.scaleimage.css;

/**
 * Different background-attachment values
 */
public enum BackgroundAttachment {

    SCROLL("scroll"), FIXED("fixed"), LOCAL("local"), INITIAL("initial"), INHERIT("inherit");

    private final String value;

    BackgroundAttachment(String value) {
        this.value = value;
    }

    public String getCssValue() {
        return value;
    }
}
