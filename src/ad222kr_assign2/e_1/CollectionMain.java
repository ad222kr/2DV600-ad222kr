package ad222kr_assign2.e_1;

public class CollectionMain {
  public static void main(String[] args) {
    /**
     * The ArrayIntList
     */

    System.out.println("List...");
    ArrayIntList list = new ArrayIntList();
    System.out.println("1. Created a new ArrayIntList");

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(42);
    System.out.println("2. Added elements to the list. 1, 2, 3, 42");
    System.out.printf("\tList.toString(): %s\n", list.toString());
    System.out.printf("\tSize of list: %d\n", list.size());

    System.out.println("3. Make sure internal array is resized");
    for (int i = 0; i < 6; i++) {
      list.add(i);
    }
    System.out.printf("\tInternal array started at 8. List now has %d elements\n", list.size());

    list.remove(3);
    list.remove(2);
    list.remove(4);
    System.out.println("4. Removing elements from the list");
    System.out.printf("\tRemoved 3 elements, list: %s\n", list.toString());
    System.out.printf("\tSize of list is now %d\n", list.size());


    System.out.println("5. Adding elements at specified index");
    list.addAt(13, 0);
    System.out.printf("\tAdded 13 at index 0. List: %s\n", list.toString());
    list.addAt(19, 2);
    System.out.printf("\tAdded 19 at index 2. List: %s\n", list.toString());
    list.addAt(77, 5);
    System.out.printf("\tAdded 77 at index 5. List: %s\n", list.toString());


    System.out.println("6. Getting elements");
    int first = list.get(0);
    int last = list.get(list.size() - 1);
    int justAnotherElement = list.get(5);
    System.out.printf("\tGot some elements from the list: %d %d %d\n", first, last, justAnotherElement);

    System.out.println("7. IndexOf");
    int indexOf5 = list.indexOf(5);
    int indexOf19 = list.indexOf(19);
    int notFound = list.indexOf(1337);
    System.out.printf("\t%s\n", list.toString());
    System.out.printf("\tIndex of 5: %d\n", indexOf5);
    System.out.printf("\tIndex of 19: %d\n", indexOf19);
    System.out.printf("\tIndex of 1337: %d\n", notFound);

    System.out.println("8. Error handling");
    try {
      list.addAt(42, 42);
    } catch (IndexOutOfBoundsException e) {
      System.out.printf("\tTried adding at non existing index, caught exception %s\n", e);
    }

    try {
      list.remove(42);
    } catch (IndexOutOfBoundsException e) {
      System.out.printf("\tTried removing at non existing index, caught exception %s\n", e);
    }

    try {
      list.get(42);
    } catch (IndexOutOfBoundsException e) {
      System.out.printf("\tTried getting at non existing index, caught exception %s\n", e);
    }

    System.out.println("Stack...");
    ArrayIntStack stack = new ArrayIntStack();
    System.out.println("1. Created stack");

    System.out.println("2. Adding elements to the stack");
    for (int i = 1; i <= 10; i++) {
      stack.push(i);
      System.out.printf("\tAdded %d to the stack\n", i);
    }
    System.out.printf("\tStack: %s\n", stack.toString());

    System.out.println("3. Popping elements");
    int firstPopped = stack.pop();


    System.out.printf("\tPopping.. returned %d\n", firstPopped);
    System.out.printf("\tStack: %s\n", stack.toString());

    int secondPopped = stack.pop();
    System.out.printf("\tPopping.. returned %d\n", secondPopped);
    System.out.printf("\tStack: %s\n", stack.toString());

    int thirdPopped = stack.pop();
    System.out.printf("\tPopping.. returned %d\n", thirdPopped);
    System.out.printf("\tStack: %s\n", stack.toString());

    System.out.println("4. Peeking elements");
    int peeked = stack.peek();
    System.out.printf("\tPeeking.. returned %d\n", peeked);
    System.out.printf("\tStack: %s\n", stack.toString());




  }
}
