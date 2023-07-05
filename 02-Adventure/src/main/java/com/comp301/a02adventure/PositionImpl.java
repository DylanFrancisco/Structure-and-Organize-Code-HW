package com.comp301.a02adventure;

public class PositionImpl implements Position {

  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    int neighborX = this.x;
    int neighborY = this.y;

    switch (direction) {
      case NORTH:
        neighborY++;
        break;
      case SOUTH:
        neighborY--;
        break;
      case EAST:
        neighborX++;
        break;
      case WEST:
        neighborX--;
        break;
    }

    return new PositionImpl(neighborX, neighborY);
  }
}
