package ad222kr_assign2.e_5.test;

import ad222kr_assign2.e_5.models.BinaryWordSet;
import ad222kr_assign2.e_5.models.Word;
import org.junit.Test;

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
  public void add_existingElement() {
    BinaryWordSet set = buildSet(20);
  }

  private BinaryWordSet buildSet(int numOfWords) {
    BinaryWordSet set = new BinaryWordSet();


    set.add(new Word("Gamma"));
    set.add(new Word("Beta"));
    set.add(new Word("Alpha"));
    set.add(new Word("Zeta"));
    set.add(new Word("Hello"));
    set.add(new Word("Xerox"));
    set.add(new Word("Soccer"));
    set.add(new Word("Football"));
    set.add(new Word("IceHockey"));


    return set;
  }

}