package org.vaadin.alump.scaleimage.css;

/**
 * Different background-repeat values
 */
public enum BackgroundRepeat {
    REPEAT("repeat"), REPEAT_X("repeat-x"), REPEAT_Y("repeat-y"), NO_REPEAT("no-repeat"), INITIAL("initial"),
    INHERIT("inherit");

    private final String value;

    BackgroundRepeat(String value) {
        this.value = value;
    }

    public String getCssValue() {
        return value;
    }
}
