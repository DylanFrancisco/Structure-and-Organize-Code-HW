package com.comp301.a02adventure;

public class CellImpl implements Cell {

  private final Position position;
  private String name;
  private String description;
  private Inventory chest;
  private boolean visited;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null");
    }
    if (description == null) {
      throw new IllegalArgumentException("Description can't be null");
    }
    this.position = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
    this.chest = null;
    this.visited = false;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null");
    }
    this.name = name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Description can't be null");
    }
    this.description = description;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public Inventory getChest() {
    return this.chest;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException("Chest can't be null");
    }
    this.chest = chest;
  }

  @Override
  public boolean getIsVisited() {
    return this.visited;
  }

  @Override
  public boolean hasChest() {
    return this.chest != null;
  }

  @Override
  public void visit() {
    this.visited = true;
  }
}
