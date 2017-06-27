/**
 * ScaleImage.java (ScaleImage)
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
package org.vaadin.alump.scaleimage;

import com.vaadin.event.MouseEvents;
import com.vaadin.shared.EventId;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ContentMode;
import org.vaadin.alump.scaleimage.css.*;
import org.vaadin.alump.scaleimage.client.share.ScaleImageServerRpc;
import org.vaadin.alump.scaleimage.client.share.ScaleImageState;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.Resource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractEmbedded;

import java.util.Arrays;
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

    @Override
    protected ScaleImageState getState(boolean markDirty) {
        return (ScaleImageState) super.getState(markDirty);
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
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundSize(BackgroundSize size) {
        setOrClearCssValue(BackgroundProperty.SIZE, size);
        return this;
    }

    /**
     * Method allows to define background size as horizontal and vertical CSS values
     * @param horizontal Horizontal value (eg. "50%" or "50px")
     * @param vertical Vertical value (eg. "50%" or "50px")
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundSize(String horizontal, String vertical) {
        setStyleProperty(BackgroundProperty.SIZE.getPropertyName(),
                Objects.requireNonNull(horizontal) + " " + Objects.requireNonNull(vertical));
        return this;
    }

    /**
     * Method allows to define how image is repeated in containing element.
     * @param repeat Background repeat
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundRepeat(BackgroundRepeat repeat) {
        setOrClearCssValue(BackgroundProperty.REPEAT, repeat);
        return this;
    }

    /**
     * Method allows to define how image is clipped in containing element.
     * @param clip Background clip
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundClip(BackgroundClip clip) {
        setOrClearCssValue(BackgroundProperty.CLIP, clip);
        return this;
    }

    /**
     * Method allows to define origin of image inside containing element.
     * @param origin Background origin
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundOrigin(BackgroundOrigin origin) {
        setOrClearCssValue(BackgroundProperty.ORIGIN, origin);
        return this;
    }

    /**
     * Method allows to define the color behind the image.
     * @param color Background color of image
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundColor(BackgroundColor color) {
        setOrClearCssValue(BackgroundProperty.COLOR, color);
        return this;
    }

    /**
     * Method allows to define image positioning in containing element.
     * @param horizontal Horizontal positioning
     * @param vertical Vertical positioning
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundPosition(BackgroundPositionX horizontal, BackgroundPositionY vertical) {
        setBackgroundPositionX(horizontal);
        setBackgroundPositionY(vertical);
        return this;
    }

    /**
     * Method allows to define background position on X axis (horizontal)
     * @param position New position or null if undefined
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundPositionX(BackgroundPositionX position) {
        setOrClearCssValue(BackgroundProperty.POSITION_X, position);
        return this;
    }

    /**
     * Method allows to define background position on Y axis (horizontal)
     * @param position New position or null if undefined
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundPositionY(BackgroundPositionY position) {
        setOrClearCssValue(BackgroundProperty.POSITION_Y, position);
        return this;
    }

    /**
     * Method allows to define background position as horizontal and vertical CSS values
     * @param horizontal Horizontal value (eg. "50%" or "50px")
     * @param vertical Vertical value (eg. "50%" or "50px")
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundPosition(String horizontal, String vertical) {
        setCssValue(BackgroundProperty.POSITION_X, horizontal);
        setCssValue(BackgroundProperty.POSITION_Y, vertical);
        return this;

    }

    /**
     * Method allows to define to what coordinates background image is attached.
     * @param attachment Attachment
     * @return Reference to this Scale Image
     */
    public ScaleImage setBackgroundAttachment(BackgroundAttachment attachment) {
        setOrClearCssValue(BackgroundProperty.ATTACHMENT, attachment);
        return this;
    }

    /**
     * Set inner content
     * @param content Inner content
     * @return Reference to this Scale Image
     */
    public ScaleImage setInnerContent(String content) {
        getState().innerContent = content;
        return this;
    }

    /**
     * Set inner content mode
     * @param mode Inner content mode
     * @return Reference to this Scale Image
     */
    public ScaleImage setInnerContentMode(ContentMode mode) {
        getState().innerContentMode = Objects.requireNonNull(mode);
        return this;
    }

    /**
     * This method allows you to inject text or HTML content inside image. Can be used to eg. present text inside
     * image.
     * @param content Content injected inside image
     * @param contentMode Content type
     * @return Reference to this Scale Image
     */
    public ScaleImage setInnerContent(String content, ContentMode contentMode) {
        setInnerContent(content);
        setInnerContentMode(contentMode);
        return this;
    }

    /**
     * Get inner content
     * @return Inner content
     */
    public String getInnerContent() {
        return getState(false).innerContent;
    }

    /**
     * Get inner content mode
     * @return Inner content mode
     */
    public ContentMode getInnerContentMode() {
        return getState(false).innerContentMode;
    }

    /**
     * Clear inner content set by setInnerContent
     */
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

    /**
     * Set CSS value of property
     * @param property Property set
     * @param value CSS value as string
     * @return Reference to this Scale Image
     */
    public ScaleImage setCssValue(BackgroundProperty property, String value) {
        setStyleProperty(property.getPropertyName(), value);
        return this;
    }

    /**
     * Set CSS value
     * @param value New value, not null
     * @return Reference to this Scale Image
     */
    public ScaleImage setCssValue(BackgroundCssValue value) {
        setStyleProperty(
                Objects.requireNonNull(value).getStyleProperty().getPropertyName(),
                value.getCssValue());
        return this;
    }

    /**
     * Set multiple CSS values
     * @param values New values, no nulls
     * @return Reference to this to allow nice one liners
     */
    public ScaleImage setCssValues(BackgroundCssValue ... values) {
        Arrays.stream(values).forEach(this::setCssValue);
        return this;
    }

    /**
     * Clear CSS value of given property. When value is cleared the (default) values from application theme apply.
     * @param property Property cleared
     */
    public void clearCssValue(BackgroundProperty property) {
        clearStyleProperty(property.getPropertyName());
    }

    /**
     * Set or clear CSS value
     * @param property Property modifed
     * @param value New value (if null then value is cleared)
     */
    protected void setOrClearCssValue(BackgroundProperty property, BackgroundCssValue value) {
        if (value != null && property != value.getStyleProperty()) {
            throw new IllegalArgumentException("Property and value does not match");
        } else if (value == null) {
            clearCssValue(property);
        } else {
            setCssValue(value);
        }
    }

}
