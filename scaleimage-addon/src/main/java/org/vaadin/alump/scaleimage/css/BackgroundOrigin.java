package org.vaadin.alump.scaleimage.css;

/**
 * Different background-origin values
 */
public enum BackgroundOrigin implements BackgroundCssValue {
    BORDER_BOX("border-box"), PADDING_BOX("padding-box"), CONTENT_BOX("content-box"), INITIAL("initial"),
    INHERIT("inherit");

    private final String value;

    BackgroundOrigin(String value) {
        this.value = value;
    }

    @Override
    public String getCssValue() {
        return value;
    }

    @Override
    public BackgroundProperty getStyleProperty() {
        return BackgroundProperty.ORIGIN;
    }
}