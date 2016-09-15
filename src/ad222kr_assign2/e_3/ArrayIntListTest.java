package ad222kr_assign2.e_3;

import ad222kr_assign2.e_1.ArrayIntList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by alex on 2016-09-15.
 */
public class ArrayIntListTest {
  ArrayIntList list;
  int initialListLength = 20;

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Before
  public void setUp(){
    list = new ArrayIntList();
    for (int i = 1; i <= initialListLength; i++) {
      list.add(i);
    }
    System.out.println();
  }

  @Test
  public void add_twentyElements() {
    int expected = initialListLength;


    int actual = list.size();

    assertEquals("The number of elements added should equal the size of the list",
      expected, actual);
  }

  @Test
  public void addAt_validIndex3() {
    int expected = 42;

    int index = 3;

    list.addAt(expected, index);

    int actual = list.get(index);

    assertEquals("The value added at a certain index should match the value at that index int the list",
      expected, actual);

  }

  @Test
  public void addAt_validIndex7() {
    int expected = 42;

    int index = 7;

    list.addAt(expected, index);

    int actual = list.get(index);

    assertEquals("The value added at a certain index should match the value at that index int the list",
      expected, actual);

  }

  @Test
  public void addAt_validIndex20() {
    int expected = 42;

    int index = 20;

    list.addAt(expected, index);

    int actual = list.get(index);

    assertEquals("The value added at a certain index should match the value at that index int the list",
      expected, actual);

  }

  @Test
  public void addAt_invalidIndex42() {
    exception.expect(IndexOutOfBoundsException.class);

    int index = 42;
    int number = 2016;

    list.addAt(number, index);
  }

  @Test
  public void addAt_invalidIndex21() {
    exception.expect(IndexOutOfBoundsException.class);

    int index = 21;
    int number = 2016;

    list.addAt(number, index);
  }

  @Test
  public void addAt_invalidIndex1337() {
    exception.expect(IndexOutOfBoundsException.class);

    int index = 1337;
    int number = 2016;

    list.addAt(number, index);
  }

  @Test
  public void remove_validIndex3() {
    int index = 3;
    int expected = initialListLength - 1;

    list.remove(index);
    int actual = list.size();

    assertEquals("The length of the list should decrease when deleting an element",
      expected, actual);


  }

  @Test
  public void remove_validIndex12() {
    int index = 12;
    int expected = initialListLength - 1;

    list.remove(index);
    int actual = list.size();

    assertEquals("The length of the list should decrease when deleting an element",
      expected, actual);


  }

  @Test
  public void remove_validIndex17() {
    int index = 17;
    int expected = initialListLength - 1;

    list.remove(index);
    int actual = list.size();

    assertEquals("The length of the list should decrease when deleting an element",
      expected, actual);

  }

  @Test
  public void remove_invalidIndex42() {
    exception.expect(IndexOutOfBoundsException.class);

    int index = 42;

    list.remove(index);
  }

  @Test
  public void remove_invalidIndex1337() {
    exception.expect(IndexOutOfBoundsException.class);

    int index = 1337;

    list.remove(index);
  }

  @Test
  public void get_validIndex() {
    int index = new Random().nextInt(initialListLength);
    int expected = 42;
    list.addAt(expected, index);

    int actual = list.get(index);

    assertEquals(String.format("The element at index %d should match %d", index, expected),
      expected, actual);
  }

  @Test
  public void get_invalidIndex() {
    exception.expect(IndexOutOfBoundsException.class);

    int index = initialListLength + new Random().nextInt(initialListLength) + 1;

    list.get(index);
  }

  @Test
  public void indexOf_existingElement() {
    int expected = new Random().nextInt(initialListLength);
    int element = list.get(expected);



    int actual = list.indexOf(element);

    assertEquals("The index of %d should match the index of the indexOf(%d) method",
      expected, actual);
  }

  @Test
  public void indexOf_nonexistingElement() {
    int expected = -1;
    int nonExistingElement = initialListLength + 42;

    int actual = list.indexOf(nonExistingElement);

    assertEquals("The index returned should be -1 for a nonexisting element",
      actual, expected);
  }

}