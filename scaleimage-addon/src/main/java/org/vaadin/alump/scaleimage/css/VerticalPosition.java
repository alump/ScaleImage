package org.vaadin.alump.scaleimage.css;

/**
 * Vertical positioning
 */
public enum VerticalPosition {
    TOP("top"), CENTER("center"), BOTTOM("bottom");

    private final String value;

    VerticalPosition(String value) {
        this.value = value;
    }

    public String getCssValue() {
        return value;
    }
}
