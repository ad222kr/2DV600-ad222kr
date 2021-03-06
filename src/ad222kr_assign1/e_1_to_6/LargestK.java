package ad222kr_assign1.e_1_to_6;

import java.util.Scanner;

public class LargestK {
  public static void main(String[] args) {
    int largestK = getLargestK();
    System.out.println(largestK);
  }
  public static int getLargestK() {
    System.out.print("Enter an integer: ");
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    if (n <= 0) throw new IllegalArgumentException("Needs to be a positive integer larger than 0");

    int k = 0;
    int sum = 0;
    while (k + sum + 2 <= n) {
      k += 2;
      sum += k;
    }

    return k;
  }
}