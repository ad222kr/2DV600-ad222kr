package ad222kr_assign1.e_7_to_13.fraction;

/**
 * Created by alex on 2016-09-07.
 */
public class FractionMain {
  public static void main(String[] args) {
    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(3, 7);
    Fraction f3 = new Fraction(2, 4);
    Fraction f4 = new Fraction(-3, 8);
    Fraction f5 = new Fraction(1, -2);

    // isNegative check
    boolean isf4Negative = f4.isNegative();
    boolean isf5Negative = f5.isNegative();
    boolean isf1Negative = f1.isNegative();

    System.out.println("__________ Fraction.isNegative()_______________");
    System.out.println(String.format("%s.isNegative() returns %s", f4.toString(), isf4Negative));
    System.out.println(String.format("%s.isNegative() returns %s", f5.toString(), isf5Negative));
    System.out.println(String.format("%s.isNegative() returns %s", f1.toString(), isf1Negative));
    System.out.println();



    Fraction sum1 = Fraction.add(f1, f2);
    Fraction sum2 = Fraction.add(f1, f3);
    Fraction sum3 = Fraction.add(f4, f5);

    System.out.println("__________ Fraction.add()______________________");
    System.out.println(String.format(
      "%s + %s returns %s",
      f1.toString(), f2.toString(), sum1.toString())
    );
    System.out.println(String.format(
      "%s + %s returns %s",
      f1.toString(), f3.toString(), sum2.toString())
    );
    System.out.println(String.format(
      "%s + %s returns %s",
      f4.toString(), f5.toString(), sum3.toString())
    );
    System.out.println();
    System.out.println("__________ Fraction.subtract()______________________");


  }
}
