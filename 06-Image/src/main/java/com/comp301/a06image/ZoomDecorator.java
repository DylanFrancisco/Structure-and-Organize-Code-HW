package com.comp301.a06image;

import java.awt.Color;

public class ZoomDecorator implements Image {

  private Image image;
  private int multiplier;

  public ZoomDecorator(Image image, int multiplier) {
    if (image == null || multiplier < 1) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    int newx = (int) Math.floor(x / multiplier);
    int newy = (int) Math.floor(y / multiplier);
    return this.image.getPixelColor(newx, newy);
  }

  @Override
  public int getWidth() {
    return this.image.getWidth() * multiplier;
  }

  @Override
  public int getHeight() {
    return this.image.getHeight() * multiplier;
  }

  @Override
  public int getNumLayers() {
    return (1 + this.image.getNumLayers());
  }
}
