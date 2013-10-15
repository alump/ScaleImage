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
 * sizing, alignment, repeating etc. By default component has undefined size, so
 * define size in CSS or define size with setWidth and setHeight functions.
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
        setSizeUndefined();
    }

    public ScaleImage(String caption) {
        this();
        setCaption(caption);
    }

    /**
     * Construct scale image with image source
     * 
     * @param caption
     * @param source
     */
    public ScaleImage(String caption, Resource source) {
        this(caption);
        setSource(source);
    }

    /**
     * Construct scale image with image source
     * 
     * @param source
     */
    public ScaleImage(Resource source) {
        this();
        setSource(source);
    }

    /**
     * Construct scale image with image source and style name
     * 
     * @param caption
     *            Caption of component
     * @param source
     *            Image source
     * @param styleName
     *            Style name of comoponent
     */
    public ScaleImage(String caption, Resource source, String styleName) {
        this(caption);
        setSource(source);
        setStyleName(styleName);
    }

    /**
     * Construct scale image with image source and style name
     * 
     * @param source
     *            Image source
     * @param styleName
     *            Style name of component
     */
    public ScaleImage(Resource source, String styleName) {
        this();
        setSource(source);
        setStyleName(styleName);
    }

    @Override
    protected ScaleImageState getState() {
        return (ScaleImageState) super.getState();
    }

    /**
     * Define style value for element at client side. Use to modify background
     * styling properties on server side. Remember to write "background-size" as
     * "backgroundSize". backgroundImage should be set with setSource unless you
     * know what you are doing.
     * 
     * @param property
     *            Property name (camel case)
     * @param value
     *            Value or property (null to unset)
     */
    protected void setStyleProperty(String property, String value) {
        getState().styleValues.put(property, value);
    }

    /**
     * Clear style property value
     * 
     * @param property
     *            Property name (camel case)
     */
    protected void clearStyleProperty(String property) {
        // Null if defined, do nothing if not defined earlier
        if (getState().styleValues.containsKey(property)) {
            getState().styleValues.put(property, null);
        }
    }

}
