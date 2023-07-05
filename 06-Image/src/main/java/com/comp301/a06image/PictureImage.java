package com.comp301.a06image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PictureImage implements Image {

  private String pathname;
  private BufferedImage image;

  public PictureImage(String pathname) throws IOException {
    if (pathname == null) {
      throw new IllegalArgumentException();
    }
    this.pathname = pathname;
    image = ImageIO.read(new File(pathname));
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException();
    }
    return new Color(image.getRGB(x, y));
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
    return 1;
  }
}
