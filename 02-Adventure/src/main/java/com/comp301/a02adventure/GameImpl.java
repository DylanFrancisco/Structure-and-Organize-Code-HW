package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {

  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException("Map or Player can't be null");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return this.player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return this.player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return new ArrayList<>(player.getInventory().getItems());
  }

  @Override
  public boolean getIsWinner() {
    int numItems = map.getNumItems();
    int numPlayerItems = player.getInventory().getNumItems();
    return numItems == numPlayerItems;
  }

  @Override
  public void printCellInfo() {
    Cell currentCell = map.getCell(player.getPosition());
    System.out.println("Location: " + currentCell.getName());
    System.out.println(currentCell.getDescription());

    if (currentCell.getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (currentCell.hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    currentCell.visit();
  }

  @Override
  public void openChest() {
    Cell currentCell = map.getCell(player.getPosition());
    if (currentCell.hasChest()) {
      Inventory chest = currentCell.getChest();
      if (chest.isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println("You collected these items: " + chest.getItems());
        player.getInventory().transferFrom(chest);
      }
    } else {
      System.out.println("No chest to open, sorry!");
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    Position playerPosition = this.player.getPosition();
    Position neighbor = playerPosition.getNeighbor(direction);
    if (neighbor.getX() < 0 || neighbor.getX() >= this.map.getWidth()) {
      return false;
    }
    if (neighbor.getY() < 0 || neighbor.getY() >= this.map.getHeight()) {
      return false;
    }
    Cell neighborCell = map.getCell(neighbor);
    return (neighborCell != null);
  }

  @Override
  public void move(Direction direction) {
    if (!(this.canMove(direction))) {
      System.out.println("You can't go that way! Try another direction.");
    } else {
      this.player.move(direction);
      this.printCellInfo();
    }
  }
}
