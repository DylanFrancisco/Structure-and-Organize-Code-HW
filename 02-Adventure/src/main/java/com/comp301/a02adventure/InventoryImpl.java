package com.comp301.a02adventure;

import java.util.ArrayList;

public class InventoryImpl implements Inventory {

  private final ArrayList<Item> inventoryList;

  public InventoryImpl() {
    this.inventoryList = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    return this.inventoryList.size() == 0;
  }

  @Override
  public int getNumItems() {
    return this.inventoryList.size();
  }

  @Override
  public ArrayList<Item> getItems() {
    ArrayList returnList = new ArrayList();
    returnList = (ArrayList) this.inventoryList.clone();
    return returnList;
  }

  @Override
  public void addItem(Item item) {
    this.inventoryList.add(item);
  }

  @Override
  public void removeItem(Item item) {
    int itemIndex = 0;
    for (int i = 0; i < this.inventoryList.size(); i++) {
      if (this.inventoryList.get(i).equals(item)) {
        itemIndex = i;
      }
    }
    inventoryList.remove(itemIndex);
  }

  @Override
  public void clear() {
    this.inventoryList.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    ArrayList<Item> transferItems = (ArrayList<Item>) other.getItems();

    for (Item item : transferItems) {
      this.addItem(item);
    }

    other.clear();
  }
}
