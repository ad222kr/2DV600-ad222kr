package ad222kr_assign2.e_5.models;

import java.util.Iterator;

/**
 * Created by alex on 2016-09-21.
 */
public class BinaryWordSet implements WordSet {
  private BSTNode root = null;
  private int size = 0;

  @Override
  public void add(Word word) {
    // TODO: check if the word exists
    if (root == null) {
      root = new BSTNode(word);
    } else {
      root.add(word);
    }
    size++;
  }

  @Override
  public boolean contains(Word word) {
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<Word> iterator() {
    return null;
  }

  private class BSTNode {
    Word value;
    BSTNode left = null;
    BSTNode right = null;

    public BSTNode(Word value) {
      this.value = value;
    }

    public void add(Word word) {
      if (value.compareTo(word) > 0) {
        if (left == null) {
          left = new BSTNode(word);
        } else {
          left.add(word);
        }
      } else if (value.compareTo(word) < 0) {
        if (right == null) {
          right = new BSTNode(word);
        } else {
          right.add(word);
        }
      }
    }

  }
}
