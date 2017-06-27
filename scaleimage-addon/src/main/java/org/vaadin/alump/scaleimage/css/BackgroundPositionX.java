package org.vaadin.alump.scaleimage.css;

/**
 * Horizontal positioning
 */
public enum BackgroundPositionX implements BackgroundCssValue {
    LEFT("left"), CENTER("center"), RIGHT("right");

    private final String value;

    BackgroundPositionX(String value) {
        this.value = value;
    }

    @Override
    public String getCssValue() {
        return value;
    }

    @Override
    public BackgroundProperty getStyleProperty() {
        return BackgroundProperty.POSITION_X;
    }
}
