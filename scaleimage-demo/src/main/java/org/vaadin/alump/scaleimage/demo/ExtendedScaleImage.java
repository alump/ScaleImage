package org.vaadin.alump.scaleimage.demo;

import org.vaadin.alump.scaleimage.ScaleImage;

/**
 * Example extending of scale image that changes CSS values from server side.
 * Usually it's pretty to just set style name and do modifications on CSS file,
 * but this offer alternative for that.
 */
@SuppressWarnings("serial")
public class ExtendedScaleImage extends ScaleImage {
    private Boolean center = null;

    public ExtendedScaleImage() {
        // For this demo do not cover scale image with background
        setStyleProperty("backgroundSize", "auto");
    }

    public void setPosition(boolean center) {
        this.center = center;
        // Jump between top left and center
        setStyleProperty("backgroundPosition", center ? "center center"
                : "top left");
    }

    public Boolean getPosition() {
        return center;
    }
}
