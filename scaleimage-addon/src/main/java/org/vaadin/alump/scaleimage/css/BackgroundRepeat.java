package org.vaadin.alump.scaleimage.css;

/**
 * Different background-repeat values
 */
public enum BackgroundRepeat implements BackgroundCssValue {
    REPEAT("repeat"), REPEAT_X("repeat-x"), REPEAT_Y("repeat-y"), NO_REPEAT("no-repeat"), INITIAL("initial"),
    INHERIT("inherit");

    private final String value;

    BackgroundRepeat(String value) {
        this.value = value;
    }

    @Override
    public String getCssValue() {
        return value;
    }

    @Override
    public BackgroundProperty getStyleProperty() {
        return BackgroundProperty.REPEAT;
    }
}
