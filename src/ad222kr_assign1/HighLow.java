package ad222kr_assign1;
import java.util.Scanner;

enum Outcome {
  LOW, HIGH, CORRECT, NO_MORE_GUESSES, INDEFINETE
}

class HighLow {
  public static void main(String[] args) {
    SecretNumber secretNumber = new SecretNumber();
    secretNumber.play();
  }
}

class SecretNumber {
  private final int MAX = 100;
  private final int MIN = 1;
  private final int MAX_GUESSES = 10;
  private int _number;
  private int _lastGuessedNumber;
  private Scanner _scanner;
  private int _numberOfGuesses;
  private Outcome _outcome;


  public SecretNumber() {
    _scanner = new Scanner(System.in);
    initiate();
  }

  private void initiate() {
    _number = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
    _numberOfGuesses = 0;
    _outcome = Outcome.INDEFINETE;
  }

  public void play() {
    while (true) {
      try {
        System.out.print("Make a guess: ");
        Outcome outcome = makeGuess();
        presentResult(outcome);

        if (!canMakeGuess()) {
          System.out.println("Type exit to quit, type anything else to play again");
          String input = _scanner.next();
          if (input.equals("quit")) {
            break;
          } else {
            initiate();
          }

        }
      } catch (Exception e) {
        System.out.println("Wrong input, try again");
      }

    }
  }

  private Outcome makeGuess() {
    _lastGuessedNumber = _scanner.nextInt();
    if (_lastGuessedNumber < MIN || _lastGuessedNumber > MAX) {
      throw new IllegalArgumentException();
    }
    _numberOfGuesses++;

    if (_lastGuessedNumber == _number) {
      _outcome = Outcome.CORRECT;
    } else if (_numberOfGuesses == MAX_GUESSES) {
      _outcome = Outcome.NO_MORE_GUESSES;
    } else if (_lastGuessedNumber < _number) {
      _outcome = Outcome.LOW;
    } else {
      _outcome = Outcome.HIGH;
    }

    return _outcome;
  }

  private boolean canMakeGuess() {
    return _numberOfGuesses < MAX_GUESSES && _outcome != Outcome.CORRECT;
  }



  private void presentResult(Outcome outcome) {
    System.out.println(String.format("Guess %1d: %2d", _numberOfGuesses, _lastGuessedNumber));
    switch (outcome) {
      case CORRECT:
        System.out.println(String.format("\tCorrect after only %1d guesses!", _numberOfGuesses));
        break;
      case LOW:
        System.out.println("\tHint: Higher!");
        break;
      case HIGH:
        System.out.println("\tHint: Lower!");
        break;
      case NO_MORE_GUESSES:
        System.out.println("\tYou have no more guesses");
        break;
    }

  }
}
