package com.comp301.a06image;

import java.awt.Color;

public class SquareDecorator implements Image {

  private Image image;
  private int squareX;
  private int squareY;
  private int squareSize;
  private Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (image == null || squareSize < 0 || color == null) {
      throw new IllegalArgumentException();
    }
    this.image = image;
    this.squareX = squareX;
    this.squareY = squareY;
    this.squareSize = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x >= squareX && x < (squareX + squareSize) && y >= squareY && y < (squareY + squareSize)) {
      return color;
    }
    return image.getPixelColor(x, y);
  }

  @Override
  public int getWidth() {
    return image.getWidth();
  }

  @Override
  public int getHeight() {
    return image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return (1 + image.getNumLayers());
  }
}
