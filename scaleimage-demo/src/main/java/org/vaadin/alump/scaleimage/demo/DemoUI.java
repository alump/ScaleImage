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

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;

import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@Title("Demo of ScaleImage")
@Theme("demo")
public class DemoUI extends UI {

    @WebServlet(value = "/*")
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "org.vaadin.alump.scaleimage.demo.ScaleImageDemoWidgetset")
    public static class DemoServlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        Navigator navigator = new Navigator(this, this);
        navigator.addView(MenuView.VIEW_NAME, MenuView.class);
        navigator.addView(TestView.VIEW_NAME, TestView.class);
        navigator.addView(AdjustView.VIEW_NAME, AdjustView.class);

    }

}
