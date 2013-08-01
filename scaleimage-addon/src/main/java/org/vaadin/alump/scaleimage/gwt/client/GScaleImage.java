package org.vaadin.alump.scaleimage.gwt.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

public class GScaleImage extends Widget {
	
	public final static String STYLE_NAME = "scale-image";
	
	public GScaleImage() {
		setElement(Document.get().createDivElement());
		setStylePrimaryName(STYLE_NAME);
	}
	
	public void setUrl(String url) {
		
		if (url != null && !url.isEmpty()) {
			String value = "url('" + url + "')";
			Logger.getLogger(getClass().getName()).log(Level.FINE, "Set background image as: '" + value + "'");
			printThis("Value is: '" + value + "'");
			getElement().getStyle().setBackgroundImage(value);
		} else {
			printThis("Value is: null");
			getElement().getStyle().clearBackgroundImage();
		}
	}
	
	private native static final void printThis(String message)
	/*-{
		console.log(message);
	}-*/;

}
