package ad222kr_assign2.e_5;

import java.util.Iterator;

/**
 * Created by alex on 20.9.16.
 */
public class HashWordSet implements WordSet {
  private int size = 0;
  private Node[] buckets = new Node[64];

  @Override
  public void add(Word word) {
    if (contains(word)) {
      return;
    }

    int bucketIndex = getBucketIndex(word);
    Node node = new Node(word);
    node.next = buckets[bucketIndex];
    buckets[bucketIndex] = node;
    size++;
    if (size == buckets.length) {
      rehash();
    }
  }

  private void rehash() {
    Node[] temp = buckets;
    buckets = new Node[temp.length * 2];
    size = 0;
    for (Node n : temp) {
      if (n == null) {
        continue;
      }

      while (n != null) {
        add(n.value);
        n = n.next;
      }
    }
  }

  @Override
  public boolean contains(Word word) {
    int bucketIndex = getBucketIndex(word);
    Node node = buckets[bucketIndex];
    while (node != null) {
      if (node.value.equals(word)) {
        return true;
      } else {
        node = node.next;
      }
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  private int getBucketIndex(Word word) {
    int hashCode = word.hashCode();

    if (hashCode < 0) hashCode *= -1;
    return hashCode % buckets.length;
  }


  @Override
  public Iterator<Word> iterator() {
    return new Iterator<Word>() {
      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public Word next() {
        return null;
      }
    };
  }
  private class Node {
    Word value;
    Node next = null;
    public Node(Word word) {
      this.value = word;
    }
    @Override
    public String toString() {
      return value.toString();
    }
  }
}
