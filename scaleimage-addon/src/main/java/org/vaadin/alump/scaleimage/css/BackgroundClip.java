package org.vaadin.alump.scaleimage.css;

/**
 * Different background-clip values
 */
public enum BackgroundClip {
    BORDER_BOX("border-box"), PADDING_BOX("padding-box"), CONTENT_BOX("content-box"), INITIAL("initial"),
    INHERIT("inherit");

    private final String value;

    BackgroundClip(String value) {
        this.value = value;
    }

    public String getCssValue() {
        return value;
    }
}
