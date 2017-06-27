ScaleImage Vaadin UI Component Add On
=====================================

[![Build Status](https://epic.siika.fi/jenkins/job/ScaleImage%20(Vaadin)/badge/icon)](https://epic.siika.fi/jenkins/job/ScaleImage%20(Vaadin)/)

Replace IMG based tags with DIV with CSS background rules. All this is get more control with CSS rules. E.g. you can
position and scale image better related to size of component and element. This also allows you to have image repeating.
ScaleImage is also clickable.

 * [Demo application](http://siika.fi:8080/ScaleImageDemo)
 * [Source code](https://github.com/alump/ScaleImage)
 * [Vaadin Directory](http://vaadin.com/directory#addon/scaleimage)
 * [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
 
## Usage
```java
// These code examples are for 0.5.0+

ScaleImage image = new ScaleImage(new ThemeResource("images/myimage.jpg"));
image.setWidth(300, Unit.PIXELS);
image.setHeight(200, Unit.PIXELS);

// Applying CSS rules related to image position and size inside element
image.setCssValues(
    BackgroundSize.CONTAIN,
    BackgroundClip.CONTENT_BOX,
    BackgroundOrigin.CONTENT_BOX,
    BackgroundPositionX.LEFT,
    BackgroundPositionY.TOP
);

// Alternative way of doing the same as above
image.setBackgroundSize(BackgroundSize.CONTAIN)
     .setBackgroundClip(BackgroundClip.CONTENT_BOX)
     .setBackgroundOrigin(BackgroundOrigin.CONTENT_BOX)
     .setBackgroundPositionX(BackgroundPositionX.LEFT)
     .setBackgroundPositionY(BackgroundPositionY.TOP);

// Attaching click listener
image.addClickListener(event -> Notification.show("Image clicked!"));
```
 
## Release notes

### Version 0.5.0 (TBD)
- API clean up
- Alternative text set to aria-label on clien side
- Widgetset name to org.vaadin.alump.scaleimage.ScaleImageWidgetset

### Version 0.4.1 (2017-03-20)
- API now allows to define all CSS values of background. Offering alternative to CSS styling all these parameters in theme.

### Version 0.4.0 (2017-03-13)
- Vaadin 8 support

### Version 0.3.0 (2016-04-06)
- OSGi bundled
- Moved to use SCSS theming (make sure you have addons.scss generated and included to your theme)
 
