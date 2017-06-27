package org.vaadin.alump.scaleimage.demo;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.vaadin.alump.scaleimage.*;
import org.vaadin.alump.scaleimage.css.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by alump on 20/03/2017.
 */
public class AdjustView extends VerticalLayout implements View {

    private Navigator navigator;

    public final static String VIEW_NAME = "adjust";

    private ScaleImage image;

    private static class PositionPair {
        private final BackgroundPositionX horizontal;
        private final BackgroundPositionY vertical;

        private PositionPair(BackgroundPositionX horizontal, BackgroundPositionY vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }

        public BackgroundPositionX getHorizontal() {
            return horizontal;
        }

        public BackgroundPositionY getVertical() {
            return vertical;
        }

        public static Collection<PositionPair> generateAll() {
            List<PositionPair> list = new ArrayList<>();
            for (BackgroundPositionX horizontal : BackgroundPositionX.values()) {
                for (BackgroundPositionY vertical : BackgroundPositionY.values()) {
                    list.add(new PositionPair(horizontal, vertical));
                }
            }
            return list;
        }

        public static PositionPair getDefault() {
            return new PositionPair(BackgroundPositionX.CENTER, BackgroundPositionY.CENTER);
        }

        public String toString() {
            return horizontal.name() + " " + vertical.name();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PositionPair)) return false;

            PositionPair that = (PositionPair) o;

            if (horizontal != that.horizontal) return false;
            return vertical == that.vertical;
        }

        @Override
        public int hashCode() {
            int result = horizontal.hashCode();
            result = 31 * result + vertical.hashCode();
            return result;
        }
    }

    public static class StringPair {
        private final String stringA;
        private final String stringB;

        public StringPair(String a, String b) {
            this.stringA = a;
            this.stringB = b;
        }

        public String getA() {
            return stringA;
        }

        public String getB() {
            return stringB;
        }

        @Override
        public String toString() {
           return getA() + " " + getB();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StringPair)) return false;

            StringPair that = (StringPair) o;

            if (!stringA.equals(that.stringA)) return false;
            return stringB.equals(that.stringB);
        }

        @Override
        public int hashCode() {
            int result = stringA.hashCode();
            result = 31 * result + stringB.hashCode();
            return result;
        }
    }

    private Component createBackgroundSizeComboBox() {
        ComboBox<Object> sizeComboBox = new ComboBox<>();

        List<Object> values = new ArrayList<>();
        Arrays.stream(BackgroundSize.values()).forEach(a -> values.add(a));
        values.add(new StringPair("50%", "50%"));
        values.add(new StringPair("200%", "200%"));
        values.add(new StringPair("100px", "100px"));
        values.add(new StringPair("20em", "20em"));
        sizeComboBox.setItems(values);

        sizeComboBox.setCaption("Background Size");
        sizeComboBox.addValueChangeListener(e -> {
            if(e.getValue() instanceof StringPair) {
                StringPair pair = (StringPair)e.getValue();
                image.setBackgroundSize(pair.getA(), pair.getB());
            } else {
                image.setBackgroundSize((BackgroundSize)e.getValue());
            }
        });
        sizeComboBox.setEmptySelectionAllowed(false);
        sizeComboBox.setValue(BackgroundSize.COVER);
        return sizeComboBox;
    }

    private Component createBackgroundPositionComboBox() {
        ComboBox<Object> positionComboBox = new ComboBox<>();

        List<Object> values = new ArrayList<>();
        PositionPair.generateAll().forEach(a -> values.add(a));
        values.add(new StringPair("5%", "5%"));
        values.add(new StringPair("95%", "95%"));
        values.add(new StringPair("10px", "30px"));
        values.add(new StringPair("1em", "2em"));
        positionComboBox.setItems(values);

        positionComboBox.setCaption("Position");
        positionComboBox.addValueChangeListener(e -> {
            if(e.getValue() instanceof StringPair) {
                StringPair pair = (StringPair)e.getValue();
                image.setBackgroundPosition(pair.getA(), pair.getB());
            } else if(e.getValue() instanceof PositionPair) {
                PositionPair pair = (PositionPair)e.getValue();
                image.setBackgroundPosition(pair.getHorizontal(), pair.getVertical());
            }
        });
        positionComboBox.setEmptySelectionAllowed(false);
        positionComboBox.setValue(PositionPair.getDefault());
        return positionComboBox;
    }

    public AdjustView() {
        setWidth(100, Unit.PERCENTAGE);
        setSpacing(true);
        setMargin(true);

        Resource image1 = new ThemeResource("images/androids.jpg");
        Resource image2 = new ThemeResource("images/redwood.jpg");
        Resource image3 = new ThemeResource("images/tile-indicator.png");
        image = new ScaleImage();
        image.addClickListener(e -> Notification.show(
                "Image clicked at " + e.getClientX() + " " + e.getClientY(),
                Notification.Type.TRAY_NOTIFICATION));

        HorizontalLayout topbar = new HorizontalLayout();
        topbar.setWidth(100, Unit.PERCENTAGE);
        topbar.setSpacing(true);
        addComponent(topbar);

        Button backToMenu = new Button("Back to menu", e -> navigator.navigateTo(MenuView.VIEW_NAME));
        topbar.addComponent(backToMenu);

        CheckBox withPadding = new CheckBox("Add padding");
        withPadding.setDescription("Set image to have padding. Can use used to test different boxes.");
        topbar.addComponent(withPadding);
        withPadding.addValueChangeListener(e -> {
            if(e.getValue()) {
                image.addStyleName("with-padding");
            } else {
                image.removeStyleName("with-padding");
            }
        });

        CheckBox disabled = new CheckBox("Disabled");
        disabled.setDescription("Disabling image will disable click handling");
        topbar.addComponents(disabled);
        disabled.addValueChangeListener(e -> {
            image.setEnabled(!e.getValue());
        });

        HorizontalLayout bar1 = new HorizontalLayout();
        bar1.setWidth(100, Unit.PERCENTAGE);
        bar1.setSpacing(true);
        addComponent(bar1);

        ComboBox<Resource> imageComboBox = new ComboBox<>();
        imageComboBox.setCaption("Image");
        imageComboBox.setItems(image1, image2, image3);
        bar1.addComponent(imageComboBox);
        imageComboBox.addValueChangeListener(e -> image.setSource(e.getValue()));
        imageComboBox.setEmptySelectionAllowed(false);
        imageComboBox.setValue(image1);

        final TextField width = new TextField();
        width.setCaption("Width (Container)");
        bar1.addComponent(width);
        width.addValueChangeListener(event -> {
            try {
                image.setWidth(event.getValue());
            } catch(IllegalArgumentException e) {
                Notification.show("Invalid value");
                width.setValue(event.getOldValue());
            }
        });
        width.setValue("500px");

        final TextField height = new TextField();
        height.setCaption("Height (Container)");
        bar1.addComponent(height);
        height.addValueChangeListener(event -> {
            try {
                image.setHeight(event.getValue());
            } catch(IllegalArgumentException e) {
                Notification.show("Invalid value");
                height.setValue(event.getOldValue());
            }
        });
        height.setValue("400px");

        bar1.addComponent(createBackgroundSizeComboBox());

        bar1.addComponent(createBackgroundPositionComboBox());

        HorizontalLayout bar2 = new HorizontalLayout();
        bar2.setWidth(100, Unit.PERCENTAGE);
        bar2.setSpacing(true);
        addComponent(bar2);

        ComboBox<BackgroundRepeat> repeatComboBox = new ComboBox<>();
        repeatComboBox.setItems(BackgroundRepeat.values());
        repeatComboBox.setCaption("Repeat");
        bar2.addComponent(repeatComboBox);
        repeatComboBox.addValueChangeListener(e -> image.setBackgroundRepeat(e.getValue()));
        repeatComboBox.setEmptySelectionAllowed(false);
        repeatComboBox.setValue(BackgroundRepeat.NO_REPEAT);

        ComboBox<BackgroundClip> clipComboBox = new ComboBox<>();
        clipComboBox.setItems(BackgroundClip.values());
        clipComboBox.setCaption("Clip");
        bar2.addComponent(clipComboBox);
        clipComboBox.addValueChangeListener(e -> image.setBackgroundClip(e.getValue()));
        clipComboBox.setEmptySelectionAllowed(false);
        clipComboBox.setValue(BackgroundClip.PADDING_BOX);

        ComboBox<BackgroundAttachment> attachmentComboBox = new ComboBox<>();
        attachmentComboBox.setItems(BackgroundAttachment.values());
        attachmentComboBox.setCaption("Attachment");
        bar2.addComponent(attachmentComboBox);
        attachmentComboBox.addValueChangeListener(e -> image.setBackgroundAttachment(e.getValue()));
        attachmentComboBox.setEmptySelectionAllowed(false);
        attachmentComboBox.setValue(BackgroundAttachment.SCROLL);

        ComboBox<BackgroundOrigin> originComboBox = new ComboBox<>();
        originComboBox.setItems(BackgroundOrigin.values());
        originComboBox.setCaption("Origin");
        bar2.addComponent(originComboBox);
        originComboBox.addValueChangeListener(e -> image.setBackgroundOrigin(e.getValue()));
        originComboBox.setEmptySelectionAllowed(false);
        originComboBox.setValue(BackgroundOrigin.PADDING_BOX);

        TextField innerContent = new TextField();
        innerContent.setCaption("Inner content");
        innerContent.addValueChangeListener(e -> image.setInnerContent(e.getValue(), ContentMode.TEXT));
        bar2.addComponent(innerContent);

        image.addStyleName("adjust-image");
        addComponent(image);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.navigator = event.getNavigator();
    }
}
