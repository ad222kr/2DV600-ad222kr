package ad222kr_assign2.e_5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alex on 21.9.16.
 */
public class HashWordSetTest {

  @Test
  public void add_wordNotInSet() {
    HashWordSet set = new HashWordSet();
    Word word = new Word("Hello");
    int expected = 1;
    set.add(word);
    int actual = set.size();

    assertEquals(expected, actual);
  }

  @Test
  public void add_wordAlreadyInSet() {
    HashWordSet set = new HashWordSet();
    Word first = new Word("Hello");
    Word second = new Word("Hello");

    int expected = 1;
    set.add(first);
    set.add(second);
    int actual = set.size();

    assertEquals(expected, actual);
  }


}