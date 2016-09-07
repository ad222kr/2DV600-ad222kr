package ad222kr_assign1.e_7_to_13.arrays;

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
    // http://www.algorithmist.com/index.php/Insertion_sort

    int[] ret = new int[arr.length];
    System.arraycopy(arr, 0, ret, 0, arr.length);
    int n = ret.length;
    for (int i = 1; i < n; i++) {
      int value = ret[i];
      int j = i - 1;
      while (j >= 0 && ret[j] > value) {
        ret[j + 1] = ret[j];
        j -= 1;
      }
      ret[j + 1] = value;
    }
    return ret;
  }

  public static boolean hasSubsequence(int[] arr, int[] sub) {
    int cursor = 0;
    while (cursor < arr.length) {
      for(int i = 0; i < sub.length; i++) {
        if (sub[i] != arr[cursor + i]) {
          break;
        }
        if (i == sub.length - 1) {
          // we are at the last element of the sub array
          // and we passed the check so the subsequence is found
          return true;
        }
      }
      cursor++;
    }

    return false;


  }

  public static int[] absDif(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) {
      throw new IllegalArgumentException("Both arrays needs to be of the same size");
    }
    int[] ret = new int[arr1.length];

    for (int i = 0; i < arr1.length; i++) {
      ret[i] = Math.abs(arr1[i] - arr2[i]);
    }

    return ret;
  }
}