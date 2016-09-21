package ad222kr_assign2.e_5;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by alex on 21.9.16.
 */
public class HashWordSetTest {

  @Test
  public void add_wordNotInSet() {
    HashWordSet set = buildHashWordSet(20);
    Word word = new Word("Hello");
    int expected = set.size() + 1;
    set.add(word);
    int actual = set.size();

    assertEquals(expected, actual);
  }

  @Test
  public void add_wordAlreadyInSet() {
    HashWordSet set = buildHashWordSet(64);
    Word first = new Word("Hello");
    Word second = new Word("Hello");

    int expected = set.size() + 1;
    set.add(first);
    set.add(second);
    int actual = set.size();

    assertEquals(expected, actual);
  }

  @Test public void add_10000Words() {
    int numOfElements = 10000;
    HashWordSet set = buildHashWordSet(0);
    for (int i = 1; i <= numOfElements; i++) {
      set.add(new Word(UUID.randomUUID().toString() + i));
    }
    int actualNumOfElements = set.size();

    assertEquals(String.format("size of the set should match %d, got %d", numOfElements, actualNumOfElements),
      numOfElements, actualNumOfElements);
  }

  @Test
  public void remove_ExistingElement() {
    HashWordSet set = buildHashWordSet(20);
    Word word = new Word("Hello");
    set.add(word);
    boolean removed = set.remove(word);

    assertTrue("remove() should return true on removin an existing element",
      removed);
  }

  @Test
  public void remove_NonExistingElement() {
    HashWordSet set = buildHashWordSet(20);
    Word word = new Word("Hello");
    boolean removed = set.remove(word);

    assertFalse("remove() should return false on removing a nonexisting element",
      removed);
  }

  @Test
  public void isEmpty_nonEmptyHashSet() {
    HashWordSet set = buildHashWordSet(20);

    boolean isEmpty = set.isEmpty();

    assertFalse("isEmpty should return false on populated set",
      isEmpty);
  }

  @Test
  public void isEmpty_emptyHashSet() {
    HashWordSet set = buildHashWordSet(0);

    boolean isEmpty = set.isEmpty();

    assertTrue("isEmpty should return true on empty set",
      isEmpty);
  }

  @Test
  public void contains_ExistingWord() {
    HashWordSet set = buildHashWordSet(20);
    set.add(new Word("Spock"));

    boolean isPresent = set.contains(new Word("Spock"));

    assertTrue("contains() should return true when the word is present",
      isPresent);
  }

  @Test
  public void contains_nonExistingWord() {
    HashWordSet set = buildHashWordSet(20);

    boolean isPresent = set.contains(new Word("Spock"));

    assertFalse("contains() should return false when the word is not present",
      isPresent);

  }

  private HashWordSet buildHashWordSet(int numOfWords) {
    HashWordSet set = new HashWordSet();

    for (int i = 1; i <= numOfWords; i++) {
      // there is virtually no way of 2 UUID being the same, but add i to the end
      // just to be sure in case there is a really edgy edge case
      set.add(new Word(String.format("%s%d", UUID.randomUUID().toString(), i)));
    }

    return set;
  }


}