package ad222kr_assign1.e_7_to_13.deck;

/**
 * Created by alex on 2016-09-08.
 */

public enum Rank {
  ACE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  KNIGHT(11),
  QUEEN(12),
  KING(13);

  private final int _value;
  private Rank (int value) {
    _value = value;
  }

  public int getValue() {
    return _value;
  }
}

