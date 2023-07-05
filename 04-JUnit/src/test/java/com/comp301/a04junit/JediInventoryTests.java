package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;

import org.junit.Test;

/** Write unit tests for the InventoryImpl class here */
public class JediInventoryTests {
  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }

  @Test
  public void testConstructor() {
    Inventory inventory = new InventoryImpl();
    assertTrue(inventory.isEmpty());
    assertEquals(0, inventory.getNumItems());
  }

  @Test
  public void testIsEmpty() {
    Inventory inventory = new InventoryImpl();
    assertTrue(inventory.isEmpty());
    Item item = new ItemImpl("Sword");
    inventory.addItem(item);
    assertFalse(inventory.isEmpty());
    inventory.removeItem(item);
    assertTrue(inventory.isEmpty());
  }

  @Test
  public void testAddItemToEmptyInventory() {
    Item item = new ItemImpl("Sword");
    Inventory inventory = new InventoryImpl();
    inventory.addItem(item);
    List<Item> items = inventory.getItems();
    assertTrue(items.contains(item));
    assertEquals(1, items.size());
  }

  @Test
  public void testAddMultipleItems() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("Sword");
    inventory.addItem(item);
    Item item1 = new ItemImpl("Wand");
    inventory.addItem(item1);
    List<Item> items = inventory.getItems();
    assertEquals(2, items.size());
    assertTrue(items.contains(item));
    assertTrue(items.contains(item1));
  }

  @Test
  public void testRemoveItem() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("Sword");
    Item item2 = new ItemImpl("Wand");
    Item item3 = new ItemImpl("Gem");
    inventory.addItem(item1);
    inventory.addItem(item2);
    inventory.addItem(item3);
    inventory.removeItem(item2);
    assertEquals(2, inventory.getNumItems());
    assertFalse(inventory.getItems().contains(item2));
  }

  @Test
  public void testRemoveNonExistingItem() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("Sword");
    Item item2 = new ItemImpl("Wand");
    Item item3 = new ItemImpl("Gem");
    Item item4 = new ItemImpl("Map");
    inventory.addItem(item1);
    inventory.addItem(item2);
    inventory.addItem(item3);
    inventory.removeItem(item4);
    assertEquals(3, inventory.getNumItems());
    assertTrue(inventory.getItems().contains(item1));
  }

  @Test
  public void testRemoveAll() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("Sword");
    Item item2 = new ItemImpl("Wand");
    Item item3 = new ItemImpl("Gem");
    inventory.addItem(item1);
    inventory.addItem(item2);
    inventory.addItem(item3);
    inventory.removeItem(item1);
    inventory.removeItem(item2);
    inventory.removeItem(item3);
    assertTrue(inventory.isEmpty());
    assertEquals(0, inventory.getNumItems());
  }

  @Test
  public void testClear() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("Sword");
    Item item2 = new ItemImpl("Wand");
    Item item3 = new ItemImpl("Gem");
    inventory.addItem(item1);
    inventory.addItem(item2);
    inventory.addItem(item3);
    inventory.clear();
    assertTrue(inventory.isEmpty());
    assertEquals(0, inventory.getNumItems());
  }

  @Test
  public void testTransferFrom() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("Sword");
    Item item2 = new ItemImpl("Wand");
    inventory.addItem(item1);
    inventory.addItem(item2);
    Inventory newInventory = new InventoryImpl();
    newInventory.transferFrom(inventory);

    assertTrue(inventory.isEmpty());
    assertEquals(0, inventory.getNumItems());
    assertFalse(newInventory.isEmpty());
    assertEquals(2, newInventory.getNumItems());
    assertTrue(newInventory.getItems().contains(item1));
    assertTrue(newInventory.getItems().contains(item2));
  }

  @Test
  public void testTransferFromWithNull() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("Sword");
    Item item2 = new ItemImpl("Wand");
    inventory.addItem(item1);
    inventory.addItem(item2);
    inventory.transferFrom(null);
    assertEquals(2, inventory.getNumItems());
    assertTrue(inventory.getItems().contains(item1));
    assertTrue(inventory.getItems().contains(item2));
  }
}
