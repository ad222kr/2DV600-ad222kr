package ad222kr_assign2.e_5;

import ad222kr_assign2.e_5.models.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by alex on 20.9.16.
 */
public class WordCount1Main {
  static HashSet<Word> hashWords = new HashSet<>();
  static TreeSet<Word> treeWords = new TreeSet<>();
  public static void main(String[] args) {
    //String filePath = "/home/alex/Code/Java/2DV600/src/ad222kr_assign2/e_5/HistoryOfProgramming.txt";
    String filePath = args[0];
    try {
      Files.lines(Paths.get(filePath))
        .map(line -> line.split("\\s+"))
        .flatMap(Arrays::stream)
        .forEach(WordCount1Main::processWord);

      for (Word word : treeWords) {
        System.out.println(word.toString());
      }

      System.out.println(String.format(
        "\nSize of the HashSet: %d",
        hashWords.size()));
      System.out.println(String.format("Size of the TreeSet: %d", treeWords.size()));

    } catch (IOException e) {
      System.out.println("Something went wrong when reading the file...");
      System.out.println("Message: " + e.getMessage());
    }
  }

  private static void processWord(String word) {
    String processedWord = word.replaceAll("[^a-zA-Z]+", "");
    Word theWord = new Word(processedWord.toLowerCase());
    hashWords.add(theWord);
    treeWords.add(theWord);
  }
}
