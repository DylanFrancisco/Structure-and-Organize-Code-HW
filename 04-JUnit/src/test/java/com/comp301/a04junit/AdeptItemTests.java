package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;

import org.junit.Test;

/** Write unit tests for the ItemImpl class here */
public class  AdeptItemTests {
  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }

  @Test
  public void testCapitalized() {
    Item item = new ItemImpl("Sword");
    assertEquals("Sword", item.getName());
  }

  @Test
  public void testEquals() {
    Item item1 = new ItemImpl("Sword");
    Item item2 = new ItemImpl("Sword");
    Item item3 = new ItemImpl("Wand");

    assertTrue(item1.equals(item1));
    assertTrue(item1.equals(item2));
    assertTrue(item2.equals(item1));

    assertFalse(item1.equals(item3));
    assertFalse(item3.equals(item1));

    assertFalse(item2.equals(item3));
    assertFalse(item3.equals(item2));
  }

  @Test
  public void testEqualsWithNull() {
    Item item = new ItemImpl("Sword");
    assertFalse(item.equals(null));
  }

  public void testItemNull() {
    Item item = new ItemImpl(null);
    Item item1 = new ItemImpl("Sword");

    assertFalse(item.equals(item1));
    assertFalse(item1.equals(item));
  }
}
