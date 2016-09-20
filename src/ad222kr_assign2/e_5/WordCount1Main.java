package ad222kr_assign2.e_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    String filePath = "/home/alex/Code/Java/2DV600/src/ad222kr_assign2/e_5/HistoryOfProgramming.txt";
    try {
      Files.lines(Paths.get(filePath))
        .map(line -> line.split("\\s+"))
        .flatMap(Arrays::stream)
        .forEach(word -> processWord(word));

      System.out.println(hashWords.size());
      System.out.println(treeWords.size());

      for (Word word : treeWords) {
        System.out.println(word.toString());
      }
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
