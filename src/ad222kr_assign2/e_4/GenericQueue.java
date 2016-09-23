package ad222kr_assign2.e_4;

import java.util.Iterator;

/**
 * Created by alex on 19.9.16.
 */
public class GenericQueue<E> implements Queue<E> {
  private int size = 0;
  private Node head = null;
  private Node tail = null;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    // might be to defensive and overkill to check all of this
    // but better be safe than sorry
    return head == null && tail == null && size == 0;
  }

  @Override
  public void enqueue(E element) {
    if (head == null) {
      head = new Node(element);
      tail = head;
    } else {
      tail.next = new Node(element);
      tail = tail.next;
    }
    size++;
  }

  @Override
  public E dequeue() throws IndexOutOfBoundsException {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("The queue is empty");
    }

    E value = head.value;
    head = head.next;
    Node node = head;
    for (int i = 1; i <= size; i++) {
      if (node != null) {
        node = node.next;
      }
    }
    size--;
    if (size == 0) {
      tail = null;
    }
    return value;
  }

  @Override
  public E first() throws IndexOutOfBoundsException {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("The queue is empty");
    }

    return head.value;
  }

  @Override
  public E last() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("The queue is empty");
    }
    return tail.value;

  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private Node node = head;
      @Override
      public boolean hasNext() {
        return node != null;
      }

      @Override
      public E next() {
        if (!hasNext()) {
          throw new IndexOutOfBoundsException("The queue does not contain a next element");
        }
        E value = node.value;
        node = node.next;
        return value;
      }
    };
  }

  private class Node {
    E value;
    Node next = null;

    public Node (E value) {
      this.value = value;
    }
  }
}
