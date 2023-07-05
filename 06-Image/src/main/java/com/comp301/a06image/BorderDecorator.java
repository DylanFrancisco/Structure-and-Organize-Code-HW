package com.comp301.a06image;

import java.awt.Color;

public class BorderDecorator implements Image {

  private final Image image;
  private final int thiccness;
  private final Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if ((image == null) || (thiccness < 0) || (borderColor == null)) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= this.getWidth() || y < 0 || y >= this.getHeight()) {
      throw new IllegalArgumentException();
    }
    if (x < this.thiccness
        || x >= image.getWidth() + thiccness
        || y < thiccness
        || y >= image.getHeight() + thiccness) {
      return borderColor;
    }
    return this.image.getPixelColor(x - thiccness, y - thiccness);
  }

  @Override
  public int getWidth() {
    return (2 * thiccness + this.image.getWidth());
  }

  @Override
  public int getHeight() {
    return (2 * thiccness + this.image.getHeight());
  }

  @Override
  public int getNumLayers() {
    return (1 + this.image.getNumLayers());
  }
}
