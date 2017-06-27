ScaleImage Vaadin UI Component Add On
=====================================

[![Build Status](https://epic.siika.fi/jenkins/job/ScaleImage%20(Vaadin)/badge/icon)](https://epic.siika.fi/jenkins/job/ScaleImage%20(Vaadin)/)

Replace IMG based tags with DIV with CSS background rules. All this is get more control with CSS rules. E.g. you can
position and scale image better related to size of component and element. This also allows you to have image repeating.
ScaleImage is also clickable.

 * [Demo application](http://app.siika.fi/ScaleImageDemo)
 * [Source code](https://github.com/alump/ScaleImage)
 * [Vaadin Directory](http://vaadin.com/directory#addon/scaleimage)
 * [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
 
## Usage
### Contain image with different aspect ratio
Scale image can used to make sure whole image is visible, and that it is aligned to center
of available space. Dashed border is added to example image to show the position and size of
background image on it.

[Contain image](./docs/images/contain.png)
```java
// These code examples are for 0.5.0+

ScaleImage image = new ScaleImage(new ThemeResource("images/myimage.jpg"));
image.setWidth(200, Unit.PIXELS);
image.setHeight(200, Unit.PIXELS);

// Option A: Applying CSS rules related to image position and size inside element
image.setCssValues(
    BackgroundSize.CONTAIN,
    BackgroundClip.PADDING_BOX,
    BackgroundOrigin.PADDING_BOX,
    BackgroundPositionX.CENTER,
    BackgroundPositionY.CENTER
);

// Option B: Alternative way of doing the same as above
image.setBackgroundSize(BackgroundSize.CONTAIN)
     .setBackgroundClip(BackgroundClip.PADDING_BOX)
     .setBackgroundOrigin(BackgroundOrigin.PADDING_BOX)
     .setBackgroundPositionX(BackgroundPositionX.CENTER)
     .setBackgroundPositionY(BackgroundPositionY.CENTER);
```

Option 3, use CSS styling in your theme. _This works also with older versions_.

In code:
```java
// Give style name
image.addStyleName("my-special-snowflake");
```
And then in theme:
```css
.my-special-snowflake {
  background-size: contain;
  background-clip: padding-box;
  background-origin: padding-box;
  background-position: center center;
}
```

### Click listener
Listening clicks is easy as...
```java
// Attaching click listener
image.addClickListener(event -> Notification.show("Image clicked!"));
```
 
## Release notes

### Version 0.5.0 (2017-06-27)
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
 
