package ad222kr_assign1;

import java.util.Scanner;
public class Backwards {


  public String reverseString() {
    System.out.println("Enter a string to reverse");

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    return new StringBuilder(input).reverse().toString();
  }
}
