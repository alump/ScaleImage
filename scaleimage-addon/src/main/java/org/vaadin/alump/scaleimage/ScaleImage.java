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

import com.vaadin.event.MouseEvents;
import com.vaadin.shared.EventId;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import org.vaadin.alump.scaleimage.css.*;
import org.vaadin.alump.scaleimage.gwt.client.share.ScaleImageServerRpc;
import org.vaadin.alump.scaleimage.gwt.client.share.ScaleImageState;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.Resource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractEmbedded;

import java.util.Objects;

/**
 * ScaleImage provides Image like features, but used DIV element and CSS
 * backgrounding for presenting. This allows you to have better control in
 * sizing, alignment, repeating etc. By default component has undefined size, so
 * define size in CSS or define size with setWidth and setHeight functions.
 */
@SuppressWarnings("serial")
public class ScaleImage extends AbstractEmbedded {

    protected final ScaleImageServerRpc rpc = new ScaleImageServerRpc() {
        @Override
        public void click(MouseEventDetails mouseDetails) {
            fireEvent(new ClickEvent(ScaleImage.this, mouseDetails));
        }
    };

    /**
     * Construct ScaleImage
     */
    public ScaleImage() {
        registerRpc(rpc, ScaleImageServerRpc.class);
        setSizeUndefined();
    }

    /**
     * Construct ScaleImage with a caption
     * @param caption
     */
    public ScaleImage(String caption) {
        this();
        setCaption(caption);
    }

    /**
     * Construct ScaleImage with a title and an image source
     * 
     * @param caption
     * @param source
     */
    public ScaleImage(String caption, Resource source) {
        this(caption);
        setSource(source);
    }

    /**
     * Construct ScaleImage with image source
     * 
     * @param source
     */
    public ScaleImage(Resource source) {
        this();
        setSource(source);
    }

    /**
     * Construct ScaleImage with a caption, an image source and a style name
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
     * Construct ScaleImage with an image source and a style name
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

    /**
     * Method allows to define how image is sized to containing element.
     * @param size Background size
     */
    public void setBackgroundSize(BackgroundSize size) {
        if(size == null) {
            clearStyleProperty("backgroundSize");
        } else {
            setStyleProperty("backgroundSize", size.getCssValue());
        }
    }

    /**
     * Method allows to define background size as horizontal and vertical CSS values
     * @param horizontal Horizontal value (eg. "50%" or "50px")
     * @param vertical Vertical value (eg. "50%" or "50px")
     */
    public void setBackgroundSize(String horizontal, String vertical) {
        setStyleProperty("backgroundSize",
                Objects.requireNonNull(horizontal) + " " + Objects.requireNonNull(vertical));
    }

    /**
     * Method allows to define how image is repeated in containing element.
     * @param repeat Background repeat
     */
    public void setBackgroundRepeat(BackgroundRepeat repeat) {
        if(repeat == null) {
             clearStyleProperty("backgroundRepeat");
        } else {
            setStyleProperty("backgroundRepeat", repeat.getCssValue());
        }
    }

    /**
     * Method allows to define how image is clipped in containing element.
     * @param clip Background clip
     */
    public void setBackgroundClip(BackgroundClip clip) {
        if(clip == null) {
            clearStyleProperty("backgroundClip");
        } else {
            setStyleProperty("backgroundClip", clip.getCssValue());
        }
    }

    /**
     * Method allows to define origin of image inside containing element.
     * @param origin Background origin
     */
    public void setBackgroundOrigin(BackgroundOrigin origin) {
        if(origin == null) {
            clearStyleProperty("backgroundOrigin");
        } else {
            setStyleProperty("backgroundOrigin", origin.getCssValue());
        }
    }

    /**
     * Method allows to define image positioning in containing element.
     * @param horizontal Horizontal positioning
     * @param vertical Vertical positioning
     */
    public void setBackgroundPosition(HorizontalPosition horizontal, VerticalPosition vertical) {
        setStyleProperty("backgroundPosition",
                Objects.requireNonNull(horizontal).getCssValue() + " "
                        + Objects.requireNonNull(vertical).getCssValue());
    }

    /**
     * Method allows to define background position as horizontal and vertical CSS values
     * @param horizontal Horizontal value (eg. "50%" or "50px")
     * @param vertical Vertical value (eg. "50%" or "50px")
     */
    public void setBackgroundPosition(String horizontal, String vertical) {
        setStyleProperty("backgroundPosition",
                Objects.requireNonNull(horizontal) + " " + Objects.requireNonNull(vertical));
    }

    /**
     * Method allows to define to what coordinates background image is attached.
     * @param attachment Attachment
     */
    public void setBackgroundAttachment(BackgroundAttachment attachment) {
        if(attachment == null) {
            clearStyleProperty("backgroundAttachment");
        } else {
            setStyleProperty("backgroundAttachment", attachment.getCssValue());
        }
    }

    /**
     * This method allows you to inject text or HTML content inside image. Can be used to eg. present text inside
     * image.
     * @param content Content injected inside image
     * @param contentMode Content type
     */
    public void setInnerContent(String content, ContentMode contentMode) {
        getState().innerContent = content;
        getState().contentMode = Objects.requireNonNull(contentMode);
    }

    public void clearInnerContent() {
        setInnerContent(null, ContentMode.TEXT);
    }

    /**
     * Add click listener
     * @param listener Listener added
     */
    public Registration addClickListener(MouseEvents.ClickListener listener) {
        return addListener(EventId.CLICK_EVENT_IDENTIFIER, ClickEvent.class, listener,
                MouseEvents.ClickListener.clickMethod);
    }

    /**
     * Remove click listener
     * @param listener Listener removed
     */
    public void removeClickListener(MouseEvents.ClickListener listener) {
        removeListener(EventId.CLICK_EVENT_IDENTIFIER, ClickEvent.class,
                listener);
    }

}
