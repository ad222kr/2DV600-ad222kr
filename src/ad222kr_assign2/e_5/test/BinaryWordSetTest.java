package ad222kr_assign2.e_5.test;

import ad222kr_assign2.e_5.models.BinaryWordSet;
import ad222kr_assign2.e_5.models.Word;
import com.sun.xml.internal.ws.resources.BindingApiMessages;
import org.junit.Test;

import java.util.Iterator;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by alex on 2016-09-22.
 */
public class BinaryWordSetTest {

  @Test
  public void add_nonExistingElement() {
    BinaryWordSet set = buildSet(20);
    Word w = new Word("Hello");
    int expectedSize = 21;
    set.add(w);

    int actualSize = set.size();

    assertEquals("The set should have one element after the operation",
      expectedSize, actualSize);

  }

  @Test
  public void add_existingElementSameCase() {
    BinaryWordSet set = buildSet(20);
    set.add(new Word("Hello"));
    int expectedSize = set.size();

    set.add(new Word("Hello"));
    int actualSize = set.size();

    assertEquals("Size should not increment when adding an existing element to the tree set",
      expectedSize, actualSize);
  }

  @Test
  public void add_existingElementDifferentCase() {
    BinaryWordSet set = buildSet(20);
    set.add(new Word("Hello"));
    int expectedSize = set.size();

    set.add(new Word("hELLo"));
    int actualSize = set.size();

    assertEquals("The element should not add a word with the same characters but different casing",
      expectedSize, actualSize);
  }

  @Test
  public void contains_nonExistingElement() {
    BinaryWordSet set = buildSet(20);
    Word w = new Word("Helo");
    boolean contains = set.contains(w);
    assertFalse("contains() should return false for a non existing elemenet",
      contains);
  }

  @Test
  public void contains_existingElementSameCasing() {
    BinaryWordSet set = buildSet(0);
    set.add(new Word("Tjenare"));
    boolean contains = set.contains(new Word("Tjenare"));
    assertTrue("contains() should return true for an existing element",
      contains);
  }

  @Test
  public void contains_exitingElementDifferentCasing() {
    BinaryWordSet set = buildSet(20);
    set.add(new Word("Nationalencyklopedin"));
    boolean contains = set.contains(new Word("nationalencyklopeDIN"));

    assertTrue("contains() should return true for an exiting elemenet with different casing",
      contains);
  }

  @Test
  public void iterator_checkReturnSorted() {
    String[] alph = "MGDQVNJERFZTOKLABXSICHYUWP".split("");
    String[] alptOrdered = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    BinaryWordSet set = new BinaryWordSet();
    for (String a : alph) {
      set.add(new Word(a));
    }

    Iterator it = set.iterator();
    int i = 0;
    while (it.hasNext()) {
      assertEquals(alptOrdered[i], it.next().toString());
      i++;
    }
  }

  private BinaryWordSet buildSet(int numOfWords) {
    BinaryWordSet set = new BinaryWordSet();
    for (int i = 0; i < numOfWords; i++) {
      set.add(new Word(UUID.randomUUID().toString() + i));
    }



    return set;
  }

}