/**
 * ScaleImageConnector.java (ScaleImage)
 * 
 * Copyright 2013-2017 Vaadin Ltd, Sami Viitanen <sami.viitanen@vaadin.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.alump.scaleimage.client.conn;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.PreElement;
import com.vaadin.shared.ui.ContentMode;
import org.vaadin.alump.scaleimage.client.GScaleImage;
import org.vaadin.alump.scaleimage.client.share.ScaleImageServerRpc;
import org.vaadin.alump.scaleimage.client.share.ScaleImageState;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.ClickEventHandler;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.AbstractEmbeddedState;
import com.vaadin.shared.ui.Connect;

/**
 * Connector for ScaleImage
 */
@SuppressWarnings("serial")
@Connect(org.vaadin.alump.scaleimage.ScaleImage.class)
public class ScaleImageConnector extends AbstractComponentConnector {
	
	@Override
	public ScaleImageState getState() {
		return (ScaleImageState)super.getState();
	}
	
	@Override
	public GScaleImage getWidget() {
		return (GScaleImage)super.getWidget();
	}
	
	@Override
	public void onStateChanged(StateChangeEvent event) {
		super.onStateChanged(event);
		
		clickEventHandler.handleEventHandlerRegistration();
		
		String url = getResourceUrl(AbstractEmbeddedState.SOURCE_RESOURCE);
        getWidget().setUrl(url);
        
        for(String property : getState().styleValues.keySet()) {
        	String value = getState().styleValues.get(property);
        	Style elementStyle = getWidget().getElement().getStyle();
        	if(value == null || value.isEmpty()) {
        		elementStyle.clearProperty(property);
        	} else {
        		elementStyle.setProperty(property, value);
        	}
        }

        if(getState().innerContentMode == ContentMode.HTML) {
			getWidget().setInnerHtml(getState().innerContent);
		} else if(getState().innerContentMode == ContentMode.PREFORMATTED) {
			PreElement preElement = Document.get().createPreElement();
			preElement.setInnerText(getState().innerContent);
			getWidget().getElement().removeAllChildren();
			getWidget().getElement().appendChild(preElement);
		} else {
        	getWidget().setInnerText(getState().innerContent);
		}

		getWidget().setAriaLabel(getState().alternateText);
	}
	
    protected final ClickEventHandler clickEventHandler = new ClickEventHandler(
            this) {

        @Override
        protected void fireClick(NativeEvent event,
                MouseEventDetails mouseDetails) {
            getRpcProxy(ScaleImageServerRpc.class).click(mouseDetails);
            event.stopPropagation();
        }

    };

}
