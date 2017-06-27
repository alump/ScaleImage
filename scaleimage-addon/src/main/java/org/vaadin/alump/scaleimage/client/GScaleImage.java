/**
 * GScaleImage.java (ScaleImage)
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
package org.vaadin.alump.scaleimage.client;

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

    public void setInnerHtml(String html) {
        getElement().setInnerHTML(html);
    }

    public void setInnerText(String text) {
        getElement().setInnerText(text);
    }

    public void setAriaLabel(String label) {
        if(label == null) {
            getElement().removeAttribute("aria-label");
        } else {
            getElement().setAttribute("aria-label", label);
        }
    }
}
