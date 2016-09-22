package ad222kr_assign2.e_5.test;

import ad222kr_assign2.e_5.models.Word;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alex on 20.9.16.
 */
public class WordTest {
  final String wordContent = "Hello";
  Word word;

  @Before
  public void setUp() {
    word = new Word(wordContent);
  }

  @Test
  public void toString_test() {
    String expected = wordContent;
    String actual = word.toString();

    assertEquals(expected, actual);
  }

  @Test
  public void hashCode_equalWords() {
    Word other = new Word(wordContent);
    int expected = word.hashCode();
    int actual = other.hashCode();

    assertEquals("2 Words with the same content should have equal hashcodes",
      expected, actual);
  }

  @Test
  public void hashCode_differentWords() {
    Word other = new Word("This is not hello");
    int firstHash = word.hashCode();
    int otherHash = other.hashCode();

    assertNotEquals("Two different words should not have the same hashcode",
      firstHash, otherHash);
  }

  @Test
  public void equals_identicalWords() {
    Word other = new Word(wordContent);

    System.out.println(word.toString());
    System.out.println(other.toString());

    assertTrue("Two identical words should equal",
      word.equals(other));
  }

  @Test
  public void equals_sameWordDifferentCasing() {
    Word other = new Word("hElLO");

    assertTrue("Two words with the same characteds but different cases should equal",
      word.equals(other));
  }

  @Test
  public void equals_differentWords() {
    Word other = new Word("THIS IS ANOTHER WORD");

    assertFalse("Two different words should not return true on compare",
      word.equals(other));
  }

  @Test
  public void compareTo_identicalWords() {
    Word other = new Word(wordContent);
    int expected = 0;
    int actual = word.compareTo(other);

    assertEquals("compareTo should return 0 on identical words",
      expected, actual);

  }

  @Test
  public void compareTo_sameWordDifferentCasing() {
    Word other = new Word("hELLO");
    int expected = 0;
    int actual = word.compareTo(other);

    assertEquals("compareTo should return 0 on word with same char-values but different case",
      expected, actual);
  }

  @Test
  public void compareTo_wordBeforeInLexicographicalOrder() {
    Word other = new Word("Alex");
    int actual = word.compareTo(other);

    assertTrue("compareTo should a positive value for a word that comes before in lexigraphical order",
      actual > 0);
  }

  @Test
  public void compareTo_wordAfterInLexicographicalOrder() {
    Word other = new Word("Waitress");
    int actual = word.compareTo(other);

    assertTrue("compareTo should return a positive value for a word that come after in lexicographical order",
      actual < 0);
  }



}