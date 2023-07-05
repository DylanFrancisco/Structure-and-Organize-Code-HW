package com.comp301.a02adventure;

public final class ItemImpl implements Item {

  private final String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null!");
    } else {
      this.name = name;
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ItemImpl)) {
      return false;
    }
    ItemImpl otherItem = (ItemImpl) other;
    return this.name.equals(otherItem.getName());
  }

  @Override
  public String toString() {
    return this.getName();
  }
}
