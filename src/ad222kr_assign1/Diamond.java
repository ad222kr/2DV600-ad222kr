package ad222kr_assign1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Diamond {
  public void draw() {
    int width = getUserInput("Please enter a positive, odd integer");

    // Top of diamond, start at 1 and go to middle
    for (int row = 1; row <= width / 2 + 1; row++) {
      for (int padding = width / 2 - row + 1; padding > 0; padding--) {
        System.out.print(" ");
      }
      for (int col = 1; col <= row * 2 - 1; col++) {
        System.out.print("*");
      }

      System.out.println();
    }

    // Bottom of diamond, start at middle - 1 and go downwards
    for (int row = width / 2; row > 0; row--) {
      for (int padding = 0; padding <= width / 2 - row; padding++) {
        System.out.print(" ");
      }
      for (int col = 1; col <= row * 2 - 1; col++) {
        System.out.print("*");
      }

      System.out.println();
    }


  }

  private int getUserInput(String prompt) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        System.out.print(prompt);

        int width = scanner.nextInt();

        if (width % 2 == 1) {
          return width;
        } else {
          throw new InputMismatchException("Needs to be a positive, odd integer");
        }
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
      } catch (Exception e) {
        System.out.println("Input messed up try again");
      }
    }
  }
}
