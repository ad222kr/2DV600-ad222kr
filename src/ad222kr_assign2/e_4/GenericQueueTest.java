package ad222kr_assign2.e_4;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GenericQueueTest {

  @Rule
  public final ExpectedException exception = ExpectedException.none();


  @Test
  public void size_emptyQueue() {
    int expected = 0;
    Queue<Integer> queue = buildIntQueue(0);

    int actual = queue.size();

    assertEquals("Empty queue should have a size of 0",
      expected, actual);
  }

  @Test
  public void size_42Elements() {
    int expected = 42;
    Queue<Integer> queue = buildIntQueue(expected);

    int actual = queue.size();
    assertEquals(String.format(
      "The queue should have a size of %d", expected
    ), expected, actual);
  }

  @Test
  public void isEmpty_emptyQueue() {
    Queue<Integer> queue = buildIntQueue(0);

    boolean actual = queue.isEmpty();

   assertTrue("isEmpty() should return true on empty queue", actual);

  }

  @Test
  public void isEmpty_nonEmptyQueue() {
    Queue<Integer> queue = buildIntQueue(5);

    boolean actual = queue.isEmpty();

    assertFalse("isEmpty() should return false on a non empty queue", actual);
  }

  @Test
  public void enqueue_OneElement() {
    Queue<Integer> queue = buildIntQueue(0);
    int expectedSize = 1;

    queue.enqueue(42);

    int actualSize = queue.size();

    assertEquals(String.format("Enqueuing %d elements should result in the size %d",
      expectedSize, expectedSize),
      expectedSize, actualSize);
  }

  @Test
  public void enqueue_42Elements() {
    Queue<Integer> queue = buildIntQueue(0);
    int expectedSize = 42;

    for (int i = 1; i <= expectedSize; i++) {
      queue.enqueue(i);
    }

    int actualSize = queue.size();

    assertEquals(String.format("Enqueuing %d elements should result in the size %d",
      expectedSize, expectedSize),
      expectedSize, actualSize);

  }

  @Test
  public void enqueue_10000Elements() {
    Queue<Integer> queue = buildIntQueue(0);
    int expectedSize = 10000;

    for (int i = 1; i <= expectedSize; i++) {
      queue.enqueue(i);
    }

    int actualSize = queue.size();

    assertEquals(String.format("Enqueuing %d elements should result in the size %d",
      expectedSize, expectedSize),
      expectedSize, actualSize);

  }
  
  @Test
  public void dequeue_nonEmptyQueue() {
    int initialSize = 42;
    Queue<Integer> queue = buildIntQueue(initialSize);
    int expectedSize = initialSize - 1;
    int expectedElement = 1; // first element is 1
    
    int actualElement = queue.dequeue();
    int actualSize = queue.size();
    
    assertEquals(String.format(
      "The dequeued element should match %d, got %d",
      expectedElement, actualElement
    ), expectedElement, actualElement);
    
    assertEquals(String.format(
      "The size of the queue should be %d, got %d",
      expectedSize, actualSize
    ), expectedSize, expectedSize);
    
  }
  
  @Test
  public void dequeue_emptyQueue() {
    exception.expect(IndexOutOfBoundsException.class);

    Queue<Integer> queue = buildIntQueue(0);

    int elem = queue.dequeue();
  }

  @Test
  public void first_nonEmptyQueue() {
    int size = 20;
    Queue<Integer> queue = buildIntQueue(size);
    int expected = 1;
    int actual = queue.first();
    int actualSize = queue.size();

    assertEquals("first() should not remove the element",
      size, actualSize);

    assertEquals("first() should return the first element %d, got %d",
      expected, actual);

  }

  @Test
  public void first_emptyQueue() {
    exception.expect(IndexOutOfBoundsException.class);

    Queue<Integer> queue = buildIntQueue(0);

    int elem = queue.first();
  }

  @Test
  public void last_nonEmptyQueue() {
    int size = 20;
    Queue<Integer> queue = buildIntQueue(size);
    int expected = size;
    int expectedSize = size;

    int actual = queue.last();
    int actualSize = queue.size();

    assertEquals("last() should not remove the element",
      expectedSize, actualSize);

    assertEquals(String.format(
      "last() should get the last element %d, got %d", expected, actual),
      expected, actual);

  }

  @Test
  public void last_first_isSameOnSingleElementQueue() {
    int size = 1;
    Queue<Integer> queue = buildIntQueue(size);

    int first = queue.first();
    int last = queue.last();

    assertEquals("The first and the last element should match if the queue only has one element",
      first, last);
  }

  @Test
  public void last_emptyQueue() {
    exception.expect(IndexOutOfBoundsException.class);

    Queue<Integer> queue = buildIntQueue(0);

    queue.last();
  }

  private Queue<Integer> buildIntQueue(int numberOfElements) {
    Queue<Integer> queue = new GenericQueue<>();

    for (int i = 1; i <= numberOfElements; i++) {
      queue.enqueue(i);
    }

    return queue;
  }
}