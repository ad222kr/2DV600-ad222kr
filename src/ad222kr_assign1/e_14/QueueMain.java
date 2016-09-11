package ad222kr_assign1.e_14;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by alex on 2016-09-11.
 */
public class QueueMain {
  public static void main(String[] args) {
    Queue queue = new Queue();

    boolean isQueueEmpty = queue.isEmpty();
    System.out.printf(
      "1. queue.isEmpty returned %s on an empty queue\n",
      isQueueEmpty
    );

    System.out.println("2. Accessing first item of an empty queue");
    try {
      Object obj = queue.first();
    } catch (IndexOutOfBoundsException e) {
      System.out.printf(
        "\tException caught: %s\n",
        e.getMessage()
      );
    }

    System.out.println("3. Accessing last item of an empty queue");
    try {
      Object obj = queue.last();
    } catch (IndexOutOfBoundsException e) {
      System.out.printf(
        "\tExcetion caught: %s\n",
        e.getMessage()
      );
    }

    System.out.println("4. Dequeing an empty queue");
    try {
      Object obj = queue.last();
    } catch (IndexOutOfBoundsException e) {
      System.out.printf(
        "\tException caught: %s\n",
        e.getMessage()
      );
    }

    System.out.println("5. Adding things...");

    TestNode first = new TestNode(1, "First Element");
    TestNode second = new TestNode(2, "Second Element");
    TestNode third = new TestNode(3, "Third Element");
    queue.enqueue(first);

    System.out.printf(
      "\tAdded an element, size of queue is %1d\n",
      queue.size()
    );
    queue.enqueue(second);
    System.out.printf(
      "\tAdded another, size of queue is %1d\n",
      queue.size()
    );
    queue.enqueue(third);
    System.out.printf(
      "\tAdded one more, size of queue is %1d\n",
      queue.size()
    );

    System.out.println("6. first(), last() and contains()");
    TestNode head = (TestNode) queue.first();
    TestNode tail = (TestNode) queue.last();
    boolean isFirstEqual = first.name == head.name && first.value == head.value;
    boolean isLastEqual = third.name == tail.name && third.value == tail.value;
    System.out.printf(
      "\tThe first element has a value of %1d and a name of %s\n",
      head.value, head.name
    );
    System.out.printf(
      "\tThe last element has a value of %1d and a name of %s\n",
      tail.value, tail.name
    );
    System.out.printf(
      "\tThe first element is equal to the one added: %s\n",
      isFirstEqual
    );
    System.out.printf(
      "\tThe last element is equal to the one added: %s\n",
      isLastEqual
    );

    TestNode thisIsNotInTheQueue = new TestNode(42, "The meaning of life");
    boolean containsElement = queue.contains(first);
    boolean containsElementNotInQueue = queue.contains(thisIsNotInTheQueue);

    System.out.printf(
      "\tThe queue contains element with value %1d, %s: %s\n",
      first.value, first.name, containsElement);

    System.out.printf(
      "\tThe queue contains element with value %1d, %s: %s\n",
      thisIsNotInTheQueue.value, thisIsNotInTheQueue.name, containsElementNotInQueue);

    System.out.println("7. Testing dequeue()");
    TestNode dequeuedNode = (TestNode) queue.dequeue();
    System.out.printf(
      "\tThe dequeued node has a value of %1d and the name %s\n",
      dequeuedNode.value, dequeuedNode.name
    );
    System.out.printf(
      "\tThe length of the queue is now %1d\n", queue.size()
    );
    TestNode dequeuedNode2 = (TestNode) queue.dequeue();
    System.out.printf(
      "\tRemoved another node, value %1d and name %s\n",
      dequeuedNode2.value, dequeuedNode2.name
    );
    System.out.printf(
      "\tThe length of the queue is now %d\n",
      queue.size()
    );

    System.out.println("8. Testing the iterator of the queue");
    // create a new queue for this
    Queue q = new Queue();
    for (int i = 1; i <= 10; i++) {
      q.enqueue(i);
    }
    System.out.printf("\tIteration with Iterator.hasNext()\n");
    Iterator it = q.iterator();
    while (it.hasNext()) {
      System.out.printf("\t\t%d\n", it.next());
    }
    System.out.println("Iteration with the for each");
    for (int i : q) {
      System.out.printf("\t\t%d\n", i);
    }

  }

  public static class TestNode {
    int value;
    String name;

    public TestNode(int value, String name) {
      this.value = value;
      this.name = name;
    }
  }


}
