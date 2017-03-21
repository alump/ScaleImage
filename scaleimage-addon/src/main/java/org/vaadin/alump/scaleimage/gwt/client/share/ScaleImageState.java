package org.vaadin.alump.scaleimage.gwt.client.share;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.shared.ui.AbstractEmbeddedState;
import com.vaadin.shared.ui.ContentMode;

@SuppressWarnings("serial")
public class ScaleImageState extends AbstractEmbeddedState {
    {
        primaryStyleName = "scale-image";
    }
    public Map<String, String> styleValues = new HashMap<String, String>();

    public String innerContent = null;
    public ContentMode contentMode = ContentMode.TEXT;
}
