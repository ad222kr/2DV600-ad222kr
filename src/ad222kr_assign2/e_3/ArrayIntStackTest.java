package ad222kr_assign2.e_3;

import ad222kr_assign2.e_1.ArrayIntStack;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ArrayIntStackTest {

  private ArrayIntStack stack;
  private int initialStackLength = 20;

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    stack = buildStack(initialStackLength);
  }

  @Test
  public void push_oneElement() {
    int numberOfElements = 1;
    int expectedLength = initialStackLength + numberOfElements;

    stack.push(42);

    int actualLength = stack.size();

    assertEquals(String.format(
      "The actual length should matdh %d", expectedLength
    ), expectedLength, actualLength);

  }

  @Test
  public void push_threeElements() {
    int numberOfElements = 3;
    int expectedLength = initialStackLength + numberOfElements;

    for (int i = 1; i <= numberOfElements; i++) {
      stack.push(i);
    }

    int actualLength = stack.size();

    assertEquals(String.format(
      "The actual length should matdh %d", expectedLength
    ), expectedLength, actualLength);

  }

  @Test
  public void push_42Elements() {
    int numberOfElements = 42;
    int expectedLength = initialStackLength + numberOfElements;

    for (int i = 1; i <= numberOfElements; i++) {
      stack.push(i);
    }

    int actualLength = stack.size();

    assertEquals(String.format(
      "The actual length should matdh %d", expectedLength
    ), expectedLength, actualLength);

  }

  @Test
  public void pop_populatedStack() {
    int expected = 20; // 20 elements in stack starting at 1
    // int expected = stack.peek();
    int expectedSize = initialStackLength - 1;

    int actual = stack.pop();
    int actualSize = stack.size();

    assertEquals(String.format(
      "The actual size should match %d", expected
    ), expectedSize, actualSize);
    assertEquals(String.format(
      "The actual element should match %d", expected
    ), expected, actual);
  }

  @Test
  public void pop_emptyStack() {
    exception.expect(IndexOutOfBoundsException.class);
    // make stack empty
    stack = buildStack(0);

    assertEquals(0, stack.size());

    int actual = stack.pop();

  }

  @Test
  public void peek_populatedStack() {
    int expected = 20; // 20 elements in stack starting at 1
    int expectedSize = initialStackLength;

    int actual = stack.peek();
    int actualSize = stack.size();

    assertEquals(String.format(
      "The actual size should match %d", expected
    ), expectedSize, actualSize);
    assertEquals(String.format(
      "The actual element should match %d", expected
    ), expected, actual);
  }

  @Test
  public void peek_emptyStack() {
    exception.expect(IndexOutOfBoundsException.class);
    // make stack empty
    stack = buildStack(0);

    assertEquals(0, stack.size());

    int actual = stack.peek();

  }

  private ArrayIntStack buildStack(int numberOfElements) {
    ArrayIntStack stack = new ArrayIntStack();
    for (int i = 1; i <= numberOfElements; i++) {
      stack.push(i);
    }

    return stack;
  }

}