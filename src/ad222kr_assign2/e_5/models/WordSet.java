package ad222kr_assign2.e_5.models;

public interface WordSet extends Iterable {
  void add(Word word); // Add word if not already added
  boolean contains(Word word); // Return true if word contained
  int size(); // Return current set size
  String toString(); // Print contained words
}