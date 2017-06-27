package org.vaadin.alump.scaleimage.demo;

import org.vaadin.alump.scaleimage.ScaleImage;
import org.vaadin.alump.scaleimage.css.*;

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
        setCssValue(BackgroundSize.AUTO);
    }

    public void setPosition(boolean center) {
        this.center = center;
        setCssValues(
                center ? BackgroundPositionX.CENTER : BackgroundPositionX.LEFT,
                center ? BackgroundPositionY.CENTER : BackgroundPositionY.TOP
        );
    }

    public Boolean getPosition() {
        return center;
    }
}
