package ad222kr_assign1.e_7_to_13.fraction;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;

/**
 * Created by alex on 2016-09-07.
 */
public class Fraction {
  private final int _numerator;
  private final int _denominator;

  public Fraction(int numerator, int denominator) {
    if (denominator == 0) throw new IllegalArgumentException("The denominator cannot be 0");
    if (denominator < 0) {
      // numerator should always be the negative for presenting and checking negative
      // value reasons. Also flips a fraction like -2/-4 to 2/4
      numerator *= -1;
      denominator *= - 1;
    }
    _numerator = numerator;
    _denominator = denominator;
  }

  public int getNumerator() {
    return _numerator;
  }
  public int getDenominator() {
    return _denominator;
  }

  public boolean isNegative() {
    // the numerator is always the negative one
    return _numerator < 0;
  }

  public static Fraction add(Fraction a, Fraction b) {
    int n;
    int d;

    if (a.getDenominator() == b.getDenominator()) {
      n = a.getNumerator() + b.getNumerator();
      d = a.getDenominator();
    } else {
      n = b.getNumerator() * a.getDenominator() + a.getNumerator() * b.getDenominator();
      d = b.getDenominator() * a.getDenominator();
    }
    return new Fraction(n, d);
  }

  public static Fraction subtract(Fraction a, Fraction b) {
    int n;
    int d;

    if (a.getDenominator() == b.getDenominator()) {
      n = a.getNumerator() - b.getNumerator();
      d = a.getDenominator();
    } else {
      n = a.getNumerator() * b.getDenominator() - a.getDenominator() * b.getNumerator();
      d = a.getDenominator() * b.getDenominator();
    }

    return new Fraction(n, d);
  }

  public static Fraction multiply(Fraction a, Fraction b) {
    int n = a.getNumerator() * b.getNumerator();
    int d = a.getDenominator() * b.getDenominator();

    return new Fraction(n, d);
  }

  public static Fraction divide(Fraction a, Fraction b) {
    int n = a.getNumerator() * b.getDenominator();
    int d = a.getDenominator() * b.getNumerator();

    return new Fraction(n, d);
  }

  public boolean isEqualTo(Fraction other) {
    return (double) this.getNumerator() / this.getDenominator() == (double) other.getNumerator() / other.getDenominator();
  }

  public String toString() {
    return String.format("%1s/%2s", _numerator, _denominator);
  }
}
