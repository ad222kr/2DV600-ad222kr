package ad222kr_assign2.e_5.models;

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
      // should return false...
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

    // return true; // should be this tbh
  }

  public boolean remove(Word word) {
    if (!contains(word)) {
      return false;
    }

    int bucketIndex = getBucketIndex(word);
    Node node = buckets[bucketIndex];

    if (node.value.equals(word)) {
      buckets[bucketIndex] = node.next;
      size--;
      return true;
    }

    while (node.next != null) {
      if (node.next.value.equals(word)) {
        node.next = node.next.next;
        size--;
        return true;
      } else {
        node = node.next;
      }
    }
    return false;
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

  public boolean isEmpty() {
    return size == 0;
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
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("The HashWordSet\n");
    sb.append("===============\n");

    for (Object word : this) {
      sb.append(word.toString() + "\n");
    }
    sb.append("End of HashWordSet\n");

    return sb.toString();
  }

  @Override
  public Iterator iterator() {
    return new WordIterator();
  }

  private class WordIterator implements Iterator<Word> {
    int pos = 0;
    Word[] words;

    public WordIterator() {
      System.out.println(size);
      words = new Word[size];
      for (int i = 0, n = 0; i < buckets.length; i++) {
        Node node = buckets[i];

        while (node != null) {
          words[n++] = node.value;
          node = node.next;
        }
      }
    }

    @Override
    public boolean hasNext() {
      return pos < words.length;
    }

    @Override
    public Word next() {
      return words[pos++];
    }
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
