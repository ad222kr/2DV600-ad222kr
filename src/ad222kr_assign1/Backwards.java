package ad222kr_assign1;

import java.util.Scanner;
public class Backwards {

  public static void main(String[] args) {
    reverseString();
  }


  public static void reverseString() {
    System.out.println("Enter a string to reverse");

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    System.out.println(new StringBuilder(input).reverse().toString());
  }
}
