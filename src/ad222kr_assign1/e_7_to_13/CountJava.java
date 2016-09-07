package ad222kr_assign1.e_7_to_13;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountJava {
  public static void main(String[] args) throws IOException {
    System.out.println(String.format("Root directory: %s", args[0]));

    ArrayList<File> files = readFiles(args[0]);
    processFiles(files);
  }

  private static ArrayList<File> readFiles(String rootDirectoryPath) throws IOException {
    ArrayList<File> files = new ArrayList<>(20);
    Files.walk(Paths.get(rootDirectoryPath)).forEach((filePath) -> {
      if (filePath.toString().toLowerCase().endsWith(".java")) {

        files.add(filePath.toFile());
      }
    });
    return files;
  }

  private static void processFiles(ArrayList<File> files) throws IOException {
    files.forEach((file) -> {
      int lineCount = 0;
      try {
        lineCount = getLinecountOfFile(file);
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(String.format("%1d. %s   lines: %2d", files.indexOf(file) + 1, file.getName(), lineCount));
    });
  }

  private static int getLinecountOfFile(File file) throws IOException {
    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
      int lineCount = 0;
      while (br.readLine() != null) lineCount++;
      return lineCount;
    }
  }
}