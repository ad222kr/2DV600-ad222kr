package ad222kr_assign1;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by alex on 2016-09-05.
 */
public class Arrays {
  public static int sum(int[] arr) {
    int sum = 0;
    for (int value : arr) {
      sum += value;
    }
    return sum;
  }

  public static String toString(int[] arr) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");

    for(int number : arr) {
      sb.append(String.format("%1d, ", number));
    }
    sb.delete(sb.length() - 2, sb.length()); // remove last comma and whitespace
    sb.append("]");
    return sb.toString();
  }

  public static int[] addN(int[] arr, int n) {
    int[] ret = new int[arr.length];

    for (int i = 0; i < ret.length; i++) {
      ret[i] = arr[i] + n;
    }

    return ret;
  }

  public static int[] reverse(int[] arr) {
    int[] ret = new int[arr.length];

    for(int left = 0, right = arr.length - 1; left < arr.length; left++, right--) {
      ret[left] = arr[right];
    }
    return ret;
  }

  public static void replaceAll(int[] arr, int oldValue, int newValue) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == oldValue) {
        arr[i] = newValue;
      }
    }
  }

  public static int[] sort(int[] arr) {
    int n = arr.length;
    while (n > 0) {
      
    }
  }

  public static boolean hasSubsequence(int[] arr, int[] sub) {
    throw new NotImplementedException();
  }

  public static int[] absDif(int[] arr1, int[] arr2) {
    throw new NotImplementedException();
  }


}
