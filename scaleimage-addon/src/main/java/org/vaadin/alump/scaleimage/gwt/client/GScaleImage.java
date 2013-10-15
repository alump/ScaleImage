package org.vaadin.alump.scaleimage.gwt.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

public class GScaleImage extends Widget {

    public GScaleImage() {
        setElement(Document.get().createDivElement());
    }

    public void setUrl(String url) {

        if (url != null && !url.isEmpty()) {
            String value = "url('" + url + "')";
            // Logger.getLogger(getClass().getName()).log(Level.FINE,
            // "Set background image as: '" + value + "'");
            getElement().getStyle().setBackgroundImage(value);
        } else {
            getElement().getStyle().clearBackgroundImage();
        }
    }

}
