package com.comp301.a02adventure;

public class PlayerImpl implements Player {

  private final String name;
  private Position position;
  private final Inventory inventory;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null");
    }

    this.name = name;
    this.position = new PositionImpl(startX, startY);
    this.inventory = new InventoryImpl();
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public Inventory getInventory() {
    return this.inventory;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void move(Direction direction) {
    this.position = this.position.getNeighbor(direction);
  }
}

