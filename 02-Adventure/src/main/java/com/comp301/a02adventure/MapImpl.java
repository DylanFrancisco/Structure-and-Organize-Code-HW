package com.comp301.a02adventure;

public class MapImpl implements Map {

  private final Cell[][] grid;
  private final int numItems;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Height or Width can't be negative");
    }
    this.grid = new Cell[width][height];
    this.numItems = numItems;
  }

  @Override
  public int getWidth() {
    return this.grid.length;
  }

  @Override
  public int getHeight() {
    return this.grid[0].length;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IndexOutOfBoundsException("X or Y are out of bounds");
    }
    return grid[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    return getCell(position.getX(), position.getY());
  }

  @Override
  public void initCell(int x, int y) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IndexOutOfBoundsException("X or Y are out of bounds");
    }
    grid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
