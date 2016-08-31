package ad222kr_assign1;
import java.util.Scanner;
public class HighLow {
  private final int MAX = 100;
  private final int MIN = 1;
  private final int MAX_GUESSES = 10;
  private int _number;
  private Scanner _scanner;

  public HighLow() {
    _number = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
    _scanner = new Scanner(System.in);

  }

  public void makeGuess() {
    int guessedNumber = _scanner.nextInt();
    if
    if (guessedNumber == _number) {
      System.out.print("Congrats, you won! ");
    }

  }
}
