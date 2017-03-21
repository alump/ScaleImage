package org.vaadin.alump.scaleimage.css;

/**
 * Different background-origin values
 */
public enum BackgroundOrigin {
    BORDER_BOX("border-box"), PADDING_BOX("padding-box"), CONTENT_BOX("content-box"), INITIAL("initial"),
    INHERIT("inherit");

    private final String value;

    BackgroundOrigin(String value) {
        this.value = value;
    }

    public String getCssValue() {
        return value;
    }
}