package ad222kr_assign1;

import java.lang.reflect.Array;

/**
 * Created by alex on 2016-09-05.
 */
public class ArraysMain {
  public static void main(String[] args) {
    int[] arr = { 1, 3, 8, 2, 9, 5 };

    // Arrays.sum()
    int sum = Arrays.sum(arr);
    System.out.println(String.format(
      "The sum of %s is %1d",
      Arrays.toString(arr), sum)
    );

    // Arrays.addN()
    int n = 2;
    int[] addNArray = Arrays.addN(arr, n);
    System.out.println(String.format(
      "The new array with %1d added to each element is %s",
      n, Arrays.toString(addNArray)
    ));

    // Arrays.reverse()
    int[] reversedArray = Arrays.reverse(arr);
    System.out.println(String.format(
      "The array %s looks like this when reversed: %s",
      Arrays.toString(arr), Arrays.toString(reversedArray)
    ));

    // Arrays.replaceAll()
    int[] arrayToReplaceValuesIn = { 1, 1, 3, 5, 6, 1, 42 };
    int replaceWith = 21;
    Arrays.replaceAll(arrayToReplaceValuesIn, 1, replaceWith);
    System.out.println(String.format(
      "Replaceing 1 with %1d mutated the array to look like this: %s",
      replaceWith, Arrays.toString(arrayToReplaceValuesIn)
    ));

    // Arrays.sort()
    int[] unsortedArray = { 1, 8, 9, 3, 5, 0, 4, 10, 7 };
    int[] sortedArray = Arrays.sort(unsortedArray);
    System.out.println(String.format(
      "Unsorted array: %s\n" +
      "Sorted array  : %s",
      Arrays.toString(unsortedArray), Arrays.toString(sortedArray)
    ));

    // Array.hasSubsequence();
    int[] arrayToCheck = { 1, 2, 3, 4, 5, 6 };
    int[] validSubsequence = { 2, 3, 4 };
    int[] anotherValidSubsequence = { 4, 5 };
    int[] invalidSubsequence = { 1, 3, 7 };
    int[] anotherInvalidSubsequence = { 3, 4, 6 };
    int[] yetAnotherValidSubsequence = { 3, 4, 5, 6 };
    int[] yetAnotherInvalidSubsequence = { 1, 2, 3, 4, 7 };

    boolean isFirstValid = Arrays.hasSubsequence(arrayToCheck, validSubsequence);
    boolean isSecondValid = Arrays.hasSubsequence(arrayToCheck, anotherValidSubsequence);
    boolean isThirdValid = Arrays.hasSubsequence(arrayToCheck, invalidSubsequence);
    boolean isFourthValid = Arrays.hasSubsequence(arrayToCheck, anotherInvalidSubsequence);
    boolean isFifthValid = Arrays.hasSubsequence(arrayToCheck, yetAnotherValidSubsequence);
    boolean isSixthValid = Arrays.hasSubsequence(arrayToCheck, yetAnotherInvalidSubsequence);

    System.out.println(String.format(
      "First one returns %s, should return true\n" +
      "Second one returns %s, should return true\n" +
      "Third returns %s, should return false\n" +
      "Fourth returns %s, should return false\n" +
      "Fifth returns %s, should return true\n" +
      "Sixth returns %s, should return false",
      isFirstValid, isSecondValid, isThirdValid, isFourthValid,
      isFifthValid, isSixthValid
    ));

    // Arrays.absDif()
    int[] arr1 = { 1, 3, 8, 3, 5 };
    int[] arr2 = { 3, 1, 4, 8, 9 };

    int[] result = Arrays.absDif(arr1, arr2);

    System.out.println(String.format(
      "Array 1: %s\n" +
      "Array 2: %s\n" +
      "Abs dif: %s",
      Arrays.toString(arr1),
      Arrays.toString(arr2),
      Arrays.toString(result)
    ));
  }
}
