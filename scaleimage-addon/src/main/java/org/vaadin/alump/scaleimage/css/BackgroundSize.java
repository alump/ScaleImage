package org.vaadin.alump.scaleimage.css;

/**
 * Different background-size values
 */
public enum BackgroundSize implements BackgroundCssValue {
    AUTO("auto"), COVER("cover"), CONTAIN("contain"), INITIAL("initial"), INHERIT("inherit");

    private final String value;

    BackgroundSize(String value) {
        this.value = value;
    }

    @Override
    public String getCssValue() {
        return value;
    }

    @Override
    public BackgroundProperty getStyleProperty() {
        return BackgroundProperty.SIZE;
    }
}
