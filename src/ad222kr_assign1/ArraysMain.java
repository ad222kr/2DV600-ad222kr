package ad222kr_assign1;

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






  }
}
