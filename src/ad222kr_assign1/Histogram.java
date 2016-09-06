package ad222kr_assign1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alex on 6.9.16.
 */
public class Histogram {
  public static void main(String[] args) throws IOException {
    String fileHandle = args[0];
    int[] integers = getIntArray(fileHandle);
    System.out.println(Arrays.toString(integers));
    countIntegers(integers);
  }

  private static int[] getIntArray(String fileHandle) throws IOException {
    System.out.println(String.format("Reading integers from the file %s", fileHandle));
    try(Scanner scanner = new Scanner(new File(fileHandle))) {
      ArrayList<Integer> integers = new ArrayList<>(20);
      while (scanner.hasNext()) {
        int x = scanner.nextInt();
        integers.add(x);
        System.out.println(x);
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

    StringBuilder sb = new StringBuilder();
  }
}
