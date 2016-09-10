package ad222kr_assign1.e_14;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

/**
 * Created by alex on 2016-09-10.
 */
public class Queue implements QueueInterface {

  private int _size = 0;
  private Node _head = null;
  private Node _tail = null;

  @Override
  public int size() {
    return _size;
  }

  @Override
  public boolean isEmpty() {
    return _head == null;
  }

  @Override
  public void enqueue(Object element) {
    if (_head == null) {
      _head = new Node(element);
      _tail = _head;
    } else {
      _tail.next = new Node(element);
      _tail = _tail.next;
    }
    _size++;
  }

  @Override
  public Object dequeue() throws IndexOutOfBoundsException {
    if (_head == null && _size == 0)
      throw new IndexOutOfBoundsException("The queue is empty");


    throw new NotImplementedException();
  }

  @Override
  public Object first() throws IndexOutOfBoundsException {
    if (_head == null && _size == 0)
      throw new IndexOutOfBoundsException("The queue is empty");

    return _head.value;
  }

  @Override
  public Object last() throws IndexOutOfBoundsException {
    if (_tail == null && _size == 0)
      throw new IndexOutOfBoundsException("The queue is empty");

    return _tail.value;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator iterator() {
    return new ListIterator();
  }



  private class ListIterator implements Iterator<Object> {
    private Node node = _head;

    @Override
    public boolean hasNext() {
      return node != null;
    }

    @Override
    public Object next() {
      if (!hasNext())
        throw new IndexOutOfBoundsException("No next element");
      Object value = node.value;
      node  = node.next;
      return value;
    }
  }

  private class Node {
    Object value;
    Node next = null;

    public Node(Object value) {
      this.value = value;
    }
  }
}
