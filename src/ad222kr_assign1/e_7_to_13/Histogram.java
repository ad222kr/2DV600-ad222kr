package ad222kr_assign1.e_7_to_13;

import ad222kr_assign1.e_7_to_13.Arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 6.9.16.
 */
public class Histogram {
  public static void main(String[] args) throws IOException {
    String fileHandle = args[0];
    int[] integers = getIntArray(fileHandle);
    countIntegers(integers);
  }

  private static int[] getIntArray(String fileHandle) throws IOException {
    System.out.println(String.format("Reading integers from the file %s", fileHandle));
    try(Scanner scanner = new Scanner(new File(fileHandle))) {
      ArrayList<Integer> integers = new ArrayList<>(20);
      while (scanner.hasNext()) {
        int x = scanner.nextInt();
        integers.add(x);
      }

      return integers.stream().mapToInt(i -> i).toArray();
    }
  }

  private static void countIntegers(int[] integers) {
    int oneToTen = 0;
    int elevenToTwenty = 0;
    int twentyoneToThirty = 0;
    int thirtyoneToForty = 0;
    int fortyoneTofifty = 0;
    int fiftyoneToSixty = 0;
    int sixtyoneToSeventy = 0;
    int seventyoneToEighty = 0;
    int eightyoneToNinety = 0;
    int ninetyoneToHundred = 0;
    int hundredoneToTwohundred = 0;

    Arrays.sort(integers);

    for(int i : integers) {
      if (i >= 1 && i <= 10)
        oneToTen++;
      else if(i >= 11 && i <= 20)
        elevenToTwenty++;
      else if(i >= 21 && i <= 30)
        twentyoneToThirty++;
      else if(i >= 31 && i <= 40)
        thirtyoneToForty++;
      else if(i >= 41 && i <= 50)
        fortyoneTofifty++;
      else if(i >= 51 && i <= 60)
        fiftyoneToSixty++;
      else if(i >= 61 && i <= 70)
        sixtyoneToSeventy++;
      else if(i >= 71 && i <= 80)
        seventyoneToEighty++;
      else if(i >= 81 && i <= 90)
        eightyoneToNinety++;
      else if(i >= 91 && i <= 10)
        ninetyoneToHundred++;
      else if(i >= 100 && i <= 200)
        hundredoneToTwohundred++;
    }

    int oneToHundred = oneToTen + elevenToTwenty + twentyoneToThirty + thirtyoneToForty + fortyoneTofifty
      + fiftyoneToSixty + sixtyoneToSeventy + seventyoneToEighty + eightyoneToNinety + ninetyoneToHundred;

    System.out.println(String.format("Integers in the interval [1, 100]: %1d", oneToHundred));
    System.out.println(String.format("Integers in the interval [101, 200]: %1d", hundredoneToTwohundred));
    System.out.println("Histogram");
    printHistogramRow("1   - 10 ", oneToTen);
    printHistogramRow("11  - 20 ", elevenToTwenty);
    printHistogramRow("21  - 30 ", twentyoneToThirty);
    printHistogramRow("31  - 40 ", thirtyoneToForty);
    printHistogramRow("41  - 50 ", fortyoneTofifty);
    printHistogramRow("51  - 60 ", fiftyoneToSixty);
    printHistogramRow("61  - 70 ", sixtyoneToSeventy);
    printHistogramRow("71  - 80 ", seventyoneToEighty);
    printHistogramRow("81  - 90 ", eightyoneToNinety);
    printHistogramRow("91  - 100", ninetyoneToHundred);
    printHistogramRow("101 - 200", hundredoneToTwohundred);
  }

  private static void printHistogramRow(String text, int count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= count; i++) {
      sb.append("*");
    }
    System.out.println(String.format("\t%s  |  %s", text, sb.toString()));
  }
}