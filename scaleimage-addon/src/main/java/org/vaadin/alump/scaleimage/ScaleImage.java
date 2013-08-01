/**
 * ScaleImage.java (ScaleImage)
 * 
 * Copyright 2013 Vaadin Ltd, Sami Viitanen <alump@vaadin.org>
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
package org.vaadin.alump.scaleimage;

import org.vaadin.alump.scaleimage.gwt.client.conn.ScaleImageServerRpc;
import org.vaadin.alump.scaleimage.gwt.client.share.ScaleImageState;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.Resource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractEmbedded;

/**
 * ScaleImage provides Image like features, but used DIV element and CSS
 * backgrounding for presenting. This allows you to have better control in
 * sizing, alignment, repeating etc. Undefined width or height isn't supported.
 */
@SuppressWarnings("serial")
public class ScaleImage extends AbstractEmbedded {
	
    protected ScaleImageServerRpc rpc = new ScaleImageServerRpc() {
        @Override
        public void click(MouseEventDetails mouseDetails) {
            fireEvent(new ClickEvent(ScaleImage.this, mouseDetails));
        }
    };
	
	public ScaleImage() {
		registerRpc(rpc, ScaleImageServerRpc.class);
		/* To prevent undefined sizes */
		setWidth(100, Unit.PIXELS);
		setHeight(100, Unit.PIXELS);
	}
	
	public ScaleImage(String caption) {
		this();
		setCaption(caption);
	}
	
    public ScaleImage(String caption, Resource source) {
        this(caption);
        setSource(source);
    }
	
	protected ScaleImageState getState() {
		return (ScaleImageState)super.getState();
	}
	
	/**
	 * Set width of ScaleImage
	 * @width Width of ScaleImage. Undefined (null or empty) not supported.
	 */
	@Override
	public void setWidth(String width) {
		if (width == null || width.isEmpty()) {
			throw new IllegalArgumentException("Undefined width not supported");
		}
		super.setWidth(width);
	}
	
	/**
	 * Set height of ScaleImage
	 * @height Height of ScaleImage. Undefined (null or empty) not supported.
	 */
	@Override
	public void setHeight(String height) {
		if (height == null || height.isEmpty()) {
			throw new IllegalArgumentException("Undefined height not supported");
		}
		super.setHeight(height);
	}
	
	/**
	 * Not supported with ScaleImage
	 */
	public void setSizeUndefined() {
		throw new UnsupportedOperationException("Undefined size not supported");
	}

}
