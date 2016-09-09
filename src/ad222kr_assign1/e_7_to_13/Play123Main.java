package ad222kr_assign1.e_7_to_13;

import ad222kr_assign1.e_7_to_13.deck.Card;
import ad222kr_assign1.e_7_to_13.deck.Deck;
import ad222kr_assign1.e_7_to_13.deck.Rank;

import java.util.Arrays;
import java.util.Queue;

/**
 * Created by alex on 9.9.16.
 */
public class Play123Main {
  public static void main(String[] args) {
    Deck deck = new Deck();
    deck.shuffle();
    int numberOfGamesToPlay = 10000;
    int winCount = 0;

//    for (int i = 1; i <= numberOfGamesToPlay; i++) {
//      if (play123(deck)) {
//        winCount++;
//      }
//      deck.initiate();
//    }

    boolean playerWon = play123(deck);
    if (playerWon)
      System.out.println("Player won");
    else
      System.out.println("Player lost");

  }

  public static boolean play123(Deck deck) {
    Rank[] loosingStreak = new Rank[] {
      Rank.ACE,
      Rank.TWO,
      Rank.THREE
    };
    boolean[] playerHitLosingCards = { false, false, false };
    System.out.println(deck.getDeckSize());
    int totalNumberOfCards = deck.getDeckSize();
    for (int i = 0, j = 1; i < totalNumberOfCards; i++) {



      for (int k = 0; k < 3; k++) {
        playerHitLosingCards[k] = false;
      }

    }
    return true;
  }
}
