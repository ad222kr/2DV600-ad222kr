package ad222kr_assign2.e_5;

import java.util.Comparator;

/**
 * Created by alex on 20.9.16.
 */
public class Word implements Comparable<Word> {
  private String word;

  public Word(String word) {
    this.word = word;
  }

  @Override
  public String toString() {
    return word;
  }

  @SuppressWarnings("unchecked")
  @Override
  public int hashCode() {

    //    int result = 17;
    //    for (int i = 0; i <= word.length(); i++) {
    //      result = 31 * result + word.charAt(i);
    //    }
    //    return result;

    return word.toLowerCase().hashCode();

  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Word) {
      Word otherWord = (Word) other;
      return word.toLowerCase().equals(otherWord.toString().toLowerCase());
    }
    return false;
  }

  @Override
  public int compareTo(Word word) {
    return this.word.compareToIgnoreCase(word.toString());
  }
}
