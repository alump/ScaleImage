package org.vaadin.alump.scaleimage.css;

/**
 * Different background-clip values
 */
public enum BackgroundClip implements BackgroundCssValue {
    BORDER_BOX("border-box"), PADDING_BOX("padding-box"), CONTENT_BOX("content-box"), INITIAL("initial"),
    INHERIT("inherit");

    private final String value;

    BackgroundClip(String value) {
        this.value = value;
    }

    @Override
    public String getCssValue() {
        return value;
    }

    @Override
    public BackgroundProperty getStyleProperty() {
        return BackgroundProperty.CLIP;
    }
}
