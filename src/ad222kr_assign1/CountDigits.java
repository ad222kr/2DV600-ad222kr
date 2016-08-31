package ad222kr_assign1;

import java.util.Scanner;
public class CountDigits {
  public void run() {
    System.out.print("Enter a positive integer: ");
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    int zeros = 0;
    int odd = 0;
    int even = 0;
    int sum = 0;

    while (number > 0) {
      int currentNumber = number % 10;

      if (currentNumber == 0) {
        zeros++;
      } else if(currentNumber % 2 == 0) {
        even++;
      } else {
        odd++;
      }

      sum += currentNumber;
      number = number / 10;
    }

    String result = String.format("Odd: %1$d\nEven: %2$d\nZeros: %3$d\nSum: %4$d\n",
      odd, even, zeros, sum);
    System.out.print(result);
  }

}