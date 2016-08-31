package ad222kr_assign1;

import java.util.Scanner;

public class LargestK {
  public int getLargestK() {
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
