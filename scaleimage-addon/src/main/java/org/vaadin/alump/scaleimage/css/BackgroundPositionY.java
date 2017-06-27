package org.vaadin.alump.scaleimage.css;

/**
 * Vertical positioning
 */
public enum BackgroundPositionY implements BackgroundCssValue {
    TOP("top"), CENTER("center"), BOTTOM("bottom");

    private final String value;

    BackgroundPositionY(String value) {
        this.value = value;
    }

    @Override
    public String getCssValue() {
        return value;
    }

    @Override
    public BackgroundProperty getStyleProperty() {
        return BackgroundProperty.POSITION_Y;
    }
}
