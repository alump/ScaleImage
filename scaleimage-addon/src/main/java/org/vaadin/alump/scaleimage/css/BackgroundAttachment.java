package org.vaadin.alump.scaleimage.css;

/**
 * Different background-attachment values
 */
public enum BackgroundAttachment implements BackgroundCssValue {

    SCROLL("scroll"), FIXED("fixed"), LOCAL("local"), INITIAL("initial"), INHERIT("inherit");

    private final String value;

    BackgroundAttachment(String value) {
        this.value = value;
    }

    @Override
    public String getCssValue() {
        return value;
    }

    @Override
    public BackgroundProperty getStyleProperty() {
        return BackgroundProperty.ATTACHMENT;
    }
}
