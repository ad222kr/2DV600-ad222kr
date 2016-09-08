package ad222kr_assign1.e_7_to_13.deck;


public class Card {
  private Rank _rank;
  private Suite _suite;

  public Card(Rank rank, Suite suite) {
    _rank = rank;
    _suite = suite;
  }

  public Rank getRank() {
    return _rank;
  }

  public Suite getSuite() {
    return _suite;
  }

  public int getFaceValue() {
    return _rank.getValue();
  }

  @Override
  public String toString() {
    return String.format(
      "%s of %s. Value: %1d",
      _rank, _suite, getFaceValue()
    );
  }
}


