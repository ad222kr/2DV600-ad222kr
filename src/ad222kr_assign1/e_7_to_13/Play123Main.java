package ad222kr_assign1.e_7_to_13;

import ad222kr_assign1.e_7_to_13.deck.Card;
import ad222kr_assign1.e_7_to_13.deck.Deck;
import ad222kr_assign1.e_7_to_13.deck.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by alex on 9.9.16.
 */
public class Play123Main {
  public static void main(String[] args) {

    int numberOfGamesToPlay = 10000;
    int winCount = 0;
    int loseCount = 0;

    for (int i = 1; i <= numberOfGamesToPlay; i++) {
      Deck deck = new Deck();
      deck.shuffle();
      if (play123(deck))
        winCount++;
      else
        loseCount++;

      deck.initiate();
    }

    float winPercent = (winCount * 100.0f) / numberOfGamesToPlay;
    System.out.printf("Number of games played: %d\n", numberOfGamesToPlay);
    System.out.printf("Number of wins: %d\n", winCount);
    System.out.printf("Number of losses: %d\n", loseCount);
    System.out.printf("Probability of winning: %.2f%%\n", winPercent);
  }

  public static boolean play123(Deck deck) {
    Rank[] loosingStreak = new Rank[] {
      Rank.ACE,
      Rank.TWO,
      Rank.THREE
    };

    int totalNumberOfCards = deck.getDeckSize();
    int losingCardCounter = 0;
    for (int i = 0; i < totalNumberOfCards; i++) {
      Card card = deck.handOutNextCard();

      if (loosingStreak[losingCardCounter].getValue() == card.getFaceValue()) {
        return false;
      }
      losingCardCounter++;
      if (losingCardCounter > 2) {
        losingCardCounter = 0;
      }

    }
    return true;
  }
}
