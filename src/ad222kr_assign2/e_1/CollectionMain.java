package ad222kr_assign2.e_1;

/**
 * Created by alex on 2016-09-12.
 */
public class CollectionMain {
  public static void main(String[] args) {
    /**
     * The ArrayIntList
     */

    ArrayIntList list = new ArrayIntList();
    System.out.println("1. Created a new ArrayIntList");

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(42);
    System.out.println("2. Added elements to the list. 1, 2, 3, 42");
    System.out.printf("\tList.toString(): %s\n", list.toString());
    System.out.printf("\tSize of list: %d\n", list.size());

    list.remove(1);
    System.out.println("3. Removing elements from the list");
    System.out.printf("\tRemoved element at index 3, list: %s\n", list.toString());
    System.out.printf("\tSize of list is now %d", list.size());


  }
}
