package org.vaadin.alump.scaleimage.demo;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import org.vaadin.alump.scaleimage.ScaleImage;

/**
 * Created by alump on 20/03/2017.
 */
public class TestView extends VerticalLayout implements View {

    public final static String VIEW_NAME = "test";

    private ExtendedScaleImage extendedImage;
    private Navigator navigator;

    public TestView() {
        setWidth(100, Unit.PERCENTAGE);

        // Big image that will scale to match with your page width, will
        // show the center of given picture. See SCSS file.
        ScaleImage bigCenterImage = new ScaleImage();
        bigCenterImage.setWidth(100, Unit.PERCENTAGE);
        bigCenterImage.setHeight(200, Unit.PIXELS);
        bigCenterImage.setStyleName("big-center-image");
        bigCenterImage.setSource(new ThemeResource("images/big-center-image.jpg"));
        bigCenterImage.addClickListener(event -> Notification.show("Big center image clicked!"));
        addComponent(bigCenterImage);

        // Tile with image, where images will be scaled to match with tile size.
        // tileimage will cover space of tile and indicator image will be at
        // top left corner.
        // Uses absolute left/right/top/down positioning. See SCSS file.
        final CssLayout tile = new CssLayout();
        tile.setStyleName("tile");
        tile.setWidth(100, Unit.PIXELS);
        tile.setHeight(100, Unit.PIXELS);
        addComponent(tile);
        tile.addLayoutClickListener(event -> {
            int size = (int) Math.round(100.0 + Math.random() * 100.0);
            tile.setWidth(size, Unit.PIXELS);
            tile.setHeight(size, Unit.PIXELS);
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
        extendedImage.setWidth(200, Unit.PIXELS);
        extendedImage.setHeight(400, Unit.PIXELS);
        extendedImage.setStyleName("extended-image");
        addComponent(extendedImage);

        Button moveButton = new Button("Move background", event -> {
            Boolean val = extendedImage.getPosition();
            if (val == null) {
                val = true;
            }

            extendedImage.setPosition(!val.booleanValue());
        });
        addComponent(moveButton);

        // Test how well scale image behaves inside alignment layout

        HorizontalLayout alignLayout = new HorizontalLayout();
        alignLayout.setSpacing(true);
        alignLayout.setWidth(200, Unit.PIXELS);
        addComponent(alignLayout);

        Label label = new Label("Alignment test:");
        label.addStyleName("align-label");
        alignLayout.addComponent(label);
        alignLayout.setExpandRatio(label, 1f);
        alignLayout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);

        ScaleImage alignImage = new ScaleImage();
        alignImage.setSource(new ThemeResource("images/tile-image.jpg"));
        alignImage.setWidth(20, Unit.PIXELS);
        alignImage.setHeight(20, Unit.PIXELS);
        alignLayout.addComponent(alignImage);
        alignLayout.setComponentAlignment(alignImage, Alignment.BOTTOM_CENTER);

        addComponent(new Button("Back to menu", e -> navigator.navigateTo(MenuView.VIEW_NAME)));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.navigator = event.getNavigator();
    }
}
