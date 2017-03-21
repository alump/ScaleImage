package org.vaadin.alump.scaleimage.css;

/**
 * Horizontal positioning
 */
public enum HorizontalPosition {
    LEFT("left"), CENTER("center"), RIGHT("right");

    private final String value;

    HorizontalPosition(String value) {
        this.value = value;
    }

    public String getCssValue() {
        return value;
    }
}
