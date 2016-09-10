package ad222kr_assign1.e_14;

/**
 * Created by alex on 2016-09-11.
 */
public class QueueMain {
  public static void main(String[] args) {
    Queue queue = new Queue();

    boolean isQueueEmpty = queue.isEmpty();
    System.out.printf("1. queue.isEmpty returned %s on an empty queue\n", isQueueEmpty
    );

    System.out.println("2. Accessing first item of an empty queue");
    try {
      Object obj = queue.first();
    } catch (IndexOutOfBoundsException e) {
      System.out.printf("\tException caught: %s\n", e.getMessage());
    }

    System.out.println("3. Accessing last item of an empty queue");
    try {
      Object obj = queue.last();
    } catch (IndexOutOfBoundsException e) {
      System.out.printf("\tExcetion caught: %s\n", e.getMessage());
    }

    System.out.println("4. Dequeing an empty queue");
    try {
      Object obj = queue.last();
    } catch (IndexOutOfBoundsException e) {
      System.out.printf("\tException caught: %s\n", e.getMessage());
    }

    System.out.println("5. Adding things...");


  }

  public class TestNode {
    int value;
    String name;

    public TestNode(int value, String name) {
      this.value = value;
      this.name = name;
    }
  }


}
