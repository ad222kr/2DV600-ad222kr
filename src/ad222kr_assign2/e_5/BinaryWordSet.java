package ad222kr_assign2.e_5;

import java.util.Iterator;

/**
 * Created by alex on 2016-09-21.
 */
public class BinaryWordSet implements WordSet {
  @Override
  public void add(Word word) {

  }

  @Override
  public boolean contains(Word word) {
    return false;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterator<Word> iterator() {
    return null;
  }

  private class Node {
    Word value;
    Node left = null;
    Node right = null;

    public Node(Word value) {
      this.value = value;
    }

    public void add(int n) {

    }

  }
}
