/**
 * DemoUI.java (ScaleImage)
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
package org.vaadin.alump.scaleimage.demo;

import org.vaadin.alump.scaleimage.ScaleImage;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Title("Demo of ScaleImage")
@Theme("demo")
public class DemoUI extends UI {

    private ExtendedScaleImage extendedImage;

    @Override
    protected void init(VaadinRequest request) {
        CssLayout layout = new CssLayout();
        layout.setSizeFull();
        setContent(layout);

        // Big image that will scale to match with your page width, will
        // show the center of given picture. See SCSS file.
        ScaleImage bigCenterImage = new ScaleImage();
        bigCenterImage.setWidth("100%");
        bigCenterImage.setHeight("200px");
        bigCenterImage.setStyleName("big-center-image");
        bigCenterImage.setSource(new ThemeResource(
                "images/big-center-image.jpg"));
        layout.addComponent(bigCenterImage);

        // Tile with image, where images will be scaled to match with tile size.
        // tileimage will cover space of tile and indicator image will be at
        // top left corner.
        // Uses absolute left/right/top/down positioning. See SCSS file.
        final CssLayout tile = new CssLayout();
        tile.setStyleName("tile");
        tile.setWidth(100, Unit.PIXELS);
        tile.setHeight(100, Unit.PIXELS);
        layout.addComponent(tile);
        tile.addLayoutClickListener(new LayoutClickListener() {

            @Override
            public void layoutClick(LayoutClickEvent event) {
                int size = (int) Math.round(100.0 + Math.random() * 100.0);
                tile.setWidth(size, Unit.PIXELS);
                tile.setHeight(size, Unit.PIXELS);
            }

        });

        ScaleImage tileImage = new ScaleImage();
        tileImage.setSource(new ThemeResource("images/tile-image.jpg"));
        tileImage.setStyleName("tile-image");
        tile.addComponent(tileImage);
        ScaleImage indicatorImage = new ScaleImage();
        indicatorImage
                .setSource(new ThemeResource("images/tile-indicator.png"));
        indicatorImage.setStyleName("tile-indicator");
        tile.addComponent(indicatorImage);
        Label tileLabel = new Label("Click tile to scale it.");
        tile.addComponent(tileLabel);

        extendedImage = new ExtendedScaleImage();
        extendedImage.setSource(new ThemeResource("images/tile-indicator.png"));
        extendedImage.setWidth("200px");
        extendedImage.setHeight("400px");
        extendedImage.setStyleName("extended-image");
        layout.addComponent(extendedImage);

        Button moveButton = new Button("Move background",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        Boolean val = extendedImage.getPosition();
                        if (val == null) {
                            val = true;
                        }

                        extendedImage.setPosition(!val.booleanValue());

                    }
                });
        layout.addComponent(moveButton);
    }

}
