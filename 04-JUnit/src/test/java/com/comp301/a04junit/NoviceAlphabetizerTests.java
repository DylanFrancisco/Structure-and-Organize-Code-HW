package com.comp301.a04junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.comp301.a04junit.alphabetizer.Alphabetizer;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/** Write tests for the Alphabetizer class here */
public class NoviceAlphabetizerTests {

  @Test
  public void unitTest1() {
    assertTrue(true); // TODO: Write your first unit test!
  }

 /* @Test
  public void testNullArray() {
    Alphabetizer alphabetizer = new Alphabetizer(null);
    assertFalse(alphabetizer.hasNext());
    assertNull(alphabetizer.next());
  } */

  @Test
  public void testNullElement() {
    String[] arrayWithNull = {"a", null};
    try {
      Alphabetizer alphabetizer = new Alphabetizer(arrayWithNull);
      fail("NullPointerException should be thrown");
    } catch (NullPointerException e){
    }
  }

  @Test
  public void testNextWithoutElements() {
    String[] in = {"a", "b", "c"};
    Alphabetizer alphabetizer = new Alphabetizer(in);
    alphabetizer.next();
    alphabetizer.next();
    alphabetizer.next();
    try {
      alphabetizer.next();
      fail();
    } catch (NoSuchElementException e){
    }
  }

  @Test
  public void testNextNullArray() {
    String[] in = null;
    Alphabetizer alphabetizer = new Alphabetizer(in);
    assertFalse(alphabetizer.hasNext());
  }

 /* @Test
  public void testIllegalState() {
    String[] emptyArray = {};
    Alphabetizer alphabetizer = new Alphabetizer(emptyArray);
    try {
      alphabetizer.next();
      fail();
    } catch (IllegalStateException e){
    }
  }*/

  @Test
  public void testHasNext() {
    String[] unsorted = {"b1", "a1", "c1"};
    Alphabetizer alphabetizer = new Alphabetizer(unsorted);
    assertTrue(alphabetizer.hasNext());
    alphabetizer.next();
    assertTrue(alphabetizer.hasNext());
    alphabetizer.next();
    assertTrue(alphabetizer.hasNext());
    alphabetizer.next();
    assertFalse(alphabetizer.hasNext());
  }

  @Test
  public void testSorting() {
    String[] unsorted = {"b1", "a1", "c1"};
    Alphabetizer alphabetizer = new Alphabetizer(unsorted);
    String[] sorted = new String[unsorted.length];
    int i = 0;
    while (alphabetizer.hasNext()){
      sorted[i++] = alphabetizer.next();
    }
    Arrays.sort(unsorted);
    assertArrayEquals(unsorted, sorted);
  }

  @Test
  public void testWithCapitals() {
    String[] in = {"a", "B", "c", "d"};
    Alphabetizer alphabetizer = new Alphabetizer(in);
    String[] expected = {"a", "B", "c", "d"};
    Arrays.sort(expected);

    for (String str : expected){
      assertTrue(alphabetizer.hasNext());
      assertEquals(str, alphabetizer.next());
    }
    assertFalse(alphabetizer.hasNext());
  }

  @Test
  public void testDoesNotMutate() {
    String[] unsorted = {"b1", "a1", "c1"};
    Alphabetizer alphabetizer = new Alphabetizer(unsorted);
    String[] sorted = new String[unsorted.length];
    int i = 0;
    while (alphabetizer.hasNext()){
      sorted[i++] = alphabetizer.next();
    }
    assertArrayEquals(new String[]{"b1", "a1", "c1"}, unsorted);
  }
}
