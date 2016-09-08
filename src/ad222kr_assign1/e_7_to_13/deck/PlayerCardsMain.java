package ad222kr_assign1.e_7_to_13.deck;

import java.util.List;

/**
 * Created by alex on 2016-09-08.
 */
public class PlayerCardsMain {
  public static void main(String[] args) {
    Deck deck = new Deck();

    // Check deck size of initial deck
    System.out.println(String.format(
      "Number of cards in deck: %1d",
      deck.getDeckSize()
    ));

    System.out.println("_____ try to add a card, should not be possble ______");
    try {
      List cards = deck.getCards();
      cards.add(new Card(Rank.ACE, Suite.CLUBS));
    } catch (Exception e) {
      System.out.println("Exception caught when trying to add a card to a read only collection");
    }
    System.out.println();


    System.out.println("_______ shuffle the deck __________");
    deck.shuffle();


    for (Card card : deck.getCards()) {
      System.out.println(card.toString());
    }
    System.out.println();

    System.out.println("__________take cards out of the deck __________");
    Card card = deck.handOutNextCard();
    System.out.println(String.format("Took a card out, it was %s", card.toString()));
    System.out.println(String.format("The size of the deck is now %1d", deck.getDeckSize()));

    Card card2 = deck.handOutNextCard();
    System.out.println(String.format("Took another card, it was %s", card2.toString()));
    System.out.println(String.format("The size of the deck is now %1d", deck.getDeckSize()));
    System.out.println();

    // Try to shuffle the deck now, should throw exception
    System.out.println("__________-try to shuffle a deck with less than 52 cards ________");
    try {
      deck.shuffle();
    } catch (Exception e) {
      System.out.println(String.format("Exception caught: %s", e.getMessage()));
    }
    System.out.println();

    System.out.println("________try to take a card from an empty deck_________");
    for (int i = 1; i <= 50; i++) {
      deck.handOutNextCard();
    }

    try {
      deck.handOutNextCard();
    } catch (Exception e) {
      System.out.println(String.format("Exception caught: %s", e.getMessage()));
    }
  }
}
