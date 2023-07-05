package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;
import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;
import com.comp301.a04junit.adventure.Player;
import com.comp301.a04junit.adventure.PlayerImpl;

import com.comp301.a04junit.adventure.Position;
import org.junit.Test;

/** Write unit tests for the PlayerImpl class here */
public class JediPlayerTests {
  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }

  @Test
  public void testConstructor() {
    Player player = new PlayerImpl("Joe", 3, 4);
    assertEquals(3, player.getPosition().getX());
    assertEquals(4, player.getPosition().getY());
    assertEquals("Joe", player.getName());
    assertNotNull(player.getInventory());
    assertNotNull(player.getPosition());
  }

  @Test
  public void testGetName() {
    Player player = new PlayerImpl("Joe", 0, 0);
    assertEquals("Joe", player.getName());
  }

  @Test
  public void testGetInventory() {
    Player player = new PlayerImpl("Joe",0,0);
    assertNotNull(player.getInventory());
    assertTrue(player.getInventory().isEmpty());
  }

  @Test
  public void testGetInventoryWithItems() {
    Player player = new PlayerImpl("Joe", 0,0);
    Inventory inventory = new InventoryImpl();
    inventory = player.getInventory();
    Item item = new ItemImpl("Sword");
    inventory.addItem(item);
    assertTrue(player.getInventory().getItems().contains(item));
    assertFalse(player.getInventory().isEmpty());
  }

  @Test
  public void testGetPosition() {
    Player player = new PlayerImpl("Joe", 2, 3);
    assertEquals(2, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
  }

  @Test
  public void testMoveNorth() {
    Player player = new PlayerImpl("Joe", 2,3);
    assertEquals(2, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
    player.move(Direction.NORTH);
    assertEquals(2, player.getPosition().getX());
    assertEquals(4,player.getPosition().getY());
  }
  @Test
  public void testMoveSouth() {
    Player player = new PlayerImpl("Joe", 2,3);
    assertEquals(2, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
    player.move(Direction.SOUTH);
    assertEquals(2, player.getPosition().getX());
    assertEquals(2,player.getPosition().getY());
  }
  @Test
  public void testMoveEast() {
    Player player = new PlayerImpl("Joe", 2,3);
    assertEquals(2, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
    player.move(Direction.EAST);
    assertEquals(3, player.getPosition().getX());
    assertEquals(3,player.getPosition().getY());
  }
  @Test
  public void testMoveWest() {
    Player player = new PlayerImpl("Joe", 2,3);
    assertEquals(2, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
    player.move(Direction.WEST);
    assertEquals(1, player.getPosition().getX());
    assertEquals(3,player.getPosition().getY());
  }
  /*@Test
  public void testMoveSouthImp() {
    Player player = new PlayerImpl("Joe", 0,0);
    assertEquals(0, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
    player.move(Direction.SOUTH);
    assertEquals(0, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
  }

  @Test
  public void testMoveWestImp() {
    Player player = new PlayerImpl("Joe", 0,0);
    assertEquals(0, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
    player.move(Direction.WEST);
    assertEquals(0, player.getPosition().getX());
    assertEquals(0, player.getPosition().getY());
  }*/
}
