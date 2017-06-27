package org.vaadin.alump.scaleimage.css;

import java.util.Objects;

/**
 * Scale image allows to define the background color behind the image. This is shown when image does not allocate the
 * whole space.
 */
public class BackgroundColor implements BackgroundCssValue {

    public final static BackgroundColor TRANSPARENT = new BackgroundColor("transparent");

    private final String color;

    public BackgroundColor(String color) {
        if(Objects.requireNonNull(color).isEmpty()) {
            throw new IllegalArgumentException("Color can not be empty");
        }
        this.color = color;
    }

    @Override
    public String toString() {
        return getCssValue();
    }

    @Override
    public String getCssValue() {
        return color;
    }

    @Override
    public BackgroundProperty getStyleProperty() {
        return BackgroundProperty.COLOR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BackgroundColor)) return false;

        BackgroundColor that = (BackgroundColor) o;

        return color.toLowerCase().equals(that.color.toLowerCase());
    }

    @Override
    public int hashCode() {
        return color.toLowerCase().hashCode();
    }
}
