package ad222kr_assign2.e_5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.stream.Collectors.toCollection;

public class IdentifyWordsMain {
  public static void main(String[] args) throws IOException {
//    String filePath = "/home/alex/Code/Java/2DV600/src/ad222kr_assign2/e_5/HistoryOfProgramming.txt";

    try {
      String filePath = args[0];
      int indexOfLastSlash = filePath.lastIndexOf("/");
      String folderPath = filePath.substring(0, indexOfLastSlash + 1);

      ArrayList<String> words = Files.lines(Paths.get(filePath))
                                  .map(line -> line.split("\\s+"))
                                  .flatMap(Arrays::stream)
                                  .collect(toCollection(ArrayList::new));

      ArrayList<String> processedWords = processWords(words);
      writeToFile(words, processedWords, folderPath);

      System.out.println(words.size());
      System.out.println(processedWords.size());
    } catch (IOException e) {
      System.out.println("Something went wrong when reading the file...");
      System.out.println("Message: " + e.getMessage());
    } catch (IndexOutOfBoundsException e) {
      System.out.println("The program expects the filepath as argument");
    }

  }

  private static void writeToFile(ArrayList<String> words,
                                  ArrayList<String> processedWords,
                                  String folderPath) throws IOException {
    Path path = Paths.get(folderPath + "result.txt");
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      writer.write("Text\n");
      writer.write("====\n");

      for (int i = 0; i < words.size(); i++) {
        writer.write(words.get(i) + " ");
        if ((i + 1) % 25 == 0) {
          writer.write("\n");
        }
      }
      writer.write("\n\nSequence of words\n");
      writer.write("=================\n");

      for (int i = 0; i < processedWords.size(); i++) {
        writer.write(processedWords.get(i) + " ");
        if ((i + 1) % 25 == 0) {
          writer.write("\n");
        }
      }
    }
  }

  private static ArrayList<String> processWords(ArrayList<String> words) {
    ArrayList<String> processedWords = new ArrayList<>(350);
    for (String word : words) {
      String processedWord = word.replaceAll("[^a-zA-Z]+", "");
      processedWords.add(processedWord);
    }

    return processedWords;
  }
}