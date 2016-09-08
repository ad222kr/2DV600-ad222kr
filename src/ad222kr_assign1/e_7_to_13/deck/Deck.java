package ad222kr_assign1.e_7_to_13.deck;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  private ArrayList<Card> _cards;

  public Deck () {
    _cards = buildDeck();
  }

  public void shuffle() {
    if (_cards.size() < 52)
      throw new IllegalStateException("You can only shuffle a complete deck");

    for (int i = 0; i < _cards.size(); i++) {
      int random = i + (int) (Math.random() * (_cards.size() - i));
      Card randomCard = _cards.get(random);
      _cards.set(random, _cards.get(i));
      _cards.set(i, randomCard);
    }
  }

  public Card handOutNextCard() {
    // maybe return null instead?
    if (_cards.isEmpty())
      throw new IllegalStateException("There are no cards left in the deck");

    Card card = _cards.get(0);
    _cards.remove(0);
    return card;

  }

  /**
   * This is just for the purpose of printing the shuffled cards in the main class
   * to show that the deck is really shuffled.
   * @return a read only list of the cards
   */
  public List<Card> getCards() {
    return Collections.unmodifiableList(_cards);
  }

  public int getDeckSize() {
    return _cards.size();
  }

  private ArrayList<Card> buildDeck() {
    ArrayList<Card> cards = new ArrayList<>(52);

    for (Suite suite : Suite.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new Card(rank, suite));
      }
    }

    return cards;
  }


}
