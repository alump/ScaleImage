package org.vaadin.alump.scaleimage.css;

/**
 * Styling properties of ScaleImage
 */
public enum BackgroundProperty {

    SIZE("backgroundSize"),
    POSITION("backgroundPosition"),
    REPEAT("backgroundRepeat"),
    CLIP("backgroundClip"),
    ORIGIN("backgroundOrigin"),
    ATTACHMENT("backgroundAttachment"),
    POSITION_X("backgroundPositionX"),
    POSITION_Y("backgroundPositionY");

    private final String name;

    BackgroundProperty(String name) {
        this.name = name;
    }

    /**
     * Name of property in camel case
     * @return Styling property in camel case
     */
    public String getPropertyName() {
        return name;
    }
}
