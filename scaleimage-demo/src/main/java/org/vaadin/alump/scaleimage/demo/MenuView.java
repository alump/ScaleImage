package org.vaadin.alump.scaleimage.demo;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class MenuView extends VerticalLayout implements View {

    public final static String VIEW_NAME = "";

    private Navigator navigator;

    public MenuView() {
        setWidth(100, Unit.PERCENTAGE);
        setMargin(true);
        setSpacing(true);

        Label header = new Label("ScaleImage Vaadin Add-on");
        header.setWidth(100, Unit.PERCENTAGE);
        header.addStyleName(ValoTheme.LABEL_H1);
        addComponent(header);

        Button adjust = new Button("Java API Background Adjust", e -> {
            navigator.navigateTo(AdjustView.VIEW_NAME);
        });
        addComponent(adjust);

        Button test = new Button("Test UI", e -> {
            navigator.navigateTo(TestView.VIEW_NAME);
        });
        addComponent(test);

        Link link = new Link("Project's GitHub page",
                new ExternalResource("https://github.com/alump/ScaleImage"));
        addComponent(link);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.navigator = event.getNavigator();
    }
}
