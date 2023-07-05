package com.comp301.a06image;

import java.awt.Color;

public class CircleDecorator implements Image {

  private Image image;
  private int cx;
  private int cy;
  private int radius;
  private Color color;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (image == null || radius < 0 || color == null) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.cx = cx;
    this.cy = cy;
    this.radius = radius;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    double dis = Math.sqrt(Math.pow(x - cx, 2) + Math.pow(y - cy, 2));
    if (dis < this.radius) {
      return color;
    }
    return image.getPixelColor(x, y);
  }

  @Override
  public int getWidth() {
    return this.image.getWidth();
  }

  @Override
  public int getHeight() {
    return this.image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return (1 + this.image.getNumLayers());
  }
}
