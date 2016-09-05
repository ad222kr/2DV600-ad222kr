package ad222kr_assign1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by alex on 2016-09-05.
 */
public class CountChars {
  public static void main(String[] args) throws IOException{
    String fileHandle = args[0];
    char[] characters = getCharArray(fileHandle);
    countCharacters(characters);

  }

  private static char[] getCharArray(String fileHandle) throws IOException  {


    try(BufferedReader br = new BufferedReader(new FileReader(fileHandle))) {
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();

      while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
      }

      return sb.toString().toCharArray();

    }
  }

  private static void countCharacters(char[] characters) {
    int upperCaseCount = 0;
    int lowerCaseCount = 0;
    int whiteSpaceCount = 0;
    int othersCount = 0;
    int numberCount = 0;

    for (char c : characters) {
      if (Character.isDigit(c))
        numberCount++;
      else if (Character.isUpperCase(c))
        upperCaseCount++;
      else if (Character.isLowerCase(c))
        lowerCaseCount++;
      else if (Character.isWhitespace(c))
        whiteSpaceCount++;
      else
        othersCount++;

    }

    String result = String.format(
      "Uppercase: %1d" +
      "\nLowercase: %2d" +
      "\nWhitespace: %3d" +
      "\nNumbers: %4d" +
      "\nOthers: %5d",
      upperCaseCount, lowerCaseCount, whiteSpaceCount, numberCount, othersCount
    );

    System.out.println(result);
  }
}
