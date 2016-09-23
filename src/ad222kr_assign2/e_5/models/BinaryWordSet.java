package ad222kr_assign2.e_5.models;

import ad222kr_assign2.e_4.GenericQueue;
import ad222kr_assign2.e_4.Queue;

import java.util.Iterator;

/**
 * Created by alex on 2016-09-21.
 */
public class BinaryWordSet implements WordSet {
  private BSTNode root = null;
  private int size = 0;

  @Override
  public void add(Word word) {
    if (root == null) {
      root = new BSTNode(word);
      size++;
    } else if (root.add(word)) {
      size++;
    }
  }

  @Override
  public boolean contains(Word word) {
    return root.contains(word);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<Word> iterator() {
    return new TreeSetIterotor();
  }

  private class TreeSetIterotor implements Iterator<Word> {
    Queue<BSTNode> queue;
    public TreeSetIterotor() {
      queue = new GenericQueue<>();
      visit(root);
    }

    private void visit(BSTNode node) {
      if (node.left != null) {
        visit(node.left);
      }
      queue.enqueue(node);
      if (node.right != null) {
        visit(node.right);
      }

    }
    @Override
    public boolean hasNext() {
      return !queue.isEmpty();
    }

    @Override
    public Word next() {
      return queue.dequeue().value;
    }
  }

  private class BSTNode {
    Word value;
    BSTNode left = null;
    BSTNode right = null;

    public BSTNode(Word value) {
      this.value = value;
    }

    public boolean add(Word word) {
      if (value.compareTo(word) > 0) {
        if (left == null) {
          left = new BSTNode(word);
          return true;
        } else {
          return left.add(word);
        }
      } else if (value.compareTo(word) < 0) {
        if (right == null) {
          right = new BSTNode(word);
          return true;
        } else {
          return right.add(word);
        }
      }
      return false;
    }

    public boolean contains(Word word) {
      if (value.compareTo(word) == 0) {
        return true;
      }
      else if (value.compareTo(word) > 0) {
        if (left == null) {
          return false;
        } else {
          return left.contains(word);
        }
      } else if (value.compareTo(word) < 0) {
        if (right == null) {
          return false;
        } else {
          return right.contains(word);
        }
      }
      return false;
    }

    public void print() {
      if (left != null) {
        left.print();
      }
      System.out.print(" " + value);
      if (right != null) {
        right.print();
      }
    }

  }
}
