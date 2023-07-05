package com.comp301.a04junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;

import org.junit.Test;

/** Write unit tests for the PositionImpl class here */
public class AdeptPositionTests {
  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }

  @Test
  public void testConstructor() {
    Position pos = new PositionImpl(1,3);
    assertEquals(1, pos.getX());
    assertEquals(3, pos.getY());
  }

  @Test
  public void testGetters() {
    Position position = new PositionImpl(-1,5);
    assertEquals(-1, position.getX());
    assertEquals(5, position.getY());

    Position position1 = new PositionImpl(7,-10);
    assertEquals(7, position1.getX());
    assertEquals(-10, position1.getY());

    Position position2 = new PositionImpl(-2, -3);
    assertEquals(-2, position2.getX());
    assertEquals(-3, position2.getY());
  }

  @Test
  public void testGettersDoNotMutate() {
    Position position = new PositionImpl(2,5);
    int xb = position.getX();
    int yb = position.getY();

    int xa = position.getX();
    int ya = position.getY();

    assertEquals(xb, xa);
    assertEquals(yb, ya);
  }

  @Test
  public void testGetNorthNeighbor() {
    Position position = new PositionImpl(2, 3);
    Position neighbor = position.getNeighbor(Direction.NORTH);
    assertEquals(2, neighbor.getX());
    assertEquals(4, neighbor.getY());
  }

  @Test
  public void testGetSouthNeighbor() {
    Position position = new PositionImpl(3, 2);
    Position neighbor = position.getNeighbor(Direction.SOUTH);
    assertEquals(3, neighbor.getX());
    assertEquals(1, neighbor.getY());
  }

  @Test
  public void testGetEastNeighbor() {
    Position position = new PositionImpl(2, 2);
    Position neighbor = position.getNeighbor(Direction.EAST);
    assertEquals(3, neighbor.getX());
    assertEquals(2, neighbor.getY());
  }

  @Test
  public void testGetWestNeighbor() {
    Position position = new PositionImpl(4, 2);
    Position neighbor = position.getNeighbor(Direction.WEST);
    assertEquals(3, neighbor.getX());
    assertEquals(2, neighbor.getY());
  }

}
