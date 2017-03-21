package org.vaadin.alump.scaleimage.css;

/**
 * Different background-size values
 */
public enum BackgroundSize {
    AUTO("auto"), COVER("cover"), CONTAIN("contain"), INITIAL("initial"), INHERIT("inherit");

    private final String value;

    BackgroundSize(String value) {
        this.value = value;
    }

    public String getCssValue() {
        return value;
    }
}
