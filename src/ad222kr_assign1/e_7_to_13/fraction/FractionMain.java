package ad222kr_assign1.e_7_to_13.fraction;

import sun.util.resources.cldr.fr.CalendarData_fr_CA;

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

    Fraction dif1 = Fraction.subtract(f1, f3);
    Fraction dif2 = Fraction.subtract(f4, f5);
    Fraction dif3 = Fraction.subtract(f4, f3);

    System.out.println(String.format(
      "%s - %s = %s",
      f1.toString(), f3.toString(), dif1.toString()
    ));
    System.out.println(String.format(
      "%s - %s = %s",
      f4.toString(), f5.toString(), dif2.toString()
    ));
    System.out.println(String.format(
      "%s - %s = %s",
      f4.toString(), f3.toString(), dif3.toString()
    ));

    System.out.println();
    System.out.println("__________Fraction.multiply()______________________");

    Fraction product1 = Fraction.multiply(f1, f3);
    Fraction product2 = Fraction.multiply(f2, f5);
    Fraction product3 = Fraction.multiply(f4, f2);

    System.out.println(String.format(
      "%s * %s = %s",
      f1.toString(), f3.toString(), product1.toString()
    ));
    System.out.println(String.format(
      "%s * %s = %s",
      f2.toString(), f5.toString(), product2.toString()
    ));
    System.out.println(String.format(
      "%s * %s = %s",
      f4.toString(), f2.toString(), product3.toString()
    ));
    System.out.println();

    System.out.println("__________Fraction.multiply()______________________");

    Fraction quotien1 = Fraction.divide(f3, f5);
    Fraction quotien2 = Fraction.divide(f4, f1);
    Fraction quotien3 = Fraction.divide(f2, f4);

    System.out.println(String.format(
      "%s ÷ %s = %s",
      f3.toString(), f5.toString(), quotien1.toString()
    ));
    System.out.println(String.format(
      "%s ÷ %s = %s",
      f4.toString(), f1.toString(), quotien2.toString()
    ));
    System.out.println(String.format(
      "%s ÷ %s = %s",
      f2.toString(), f4.toString(), quotien3.toString()
    ));
    System.out.println();

    System.out.println("__________Fraction.isEqualTo()______________________");

    boolean isEqual1 = f1.isEqualTo(f3);
    boolean isEqual2 = f1.isEqualTo(f5);
    boolean isEqual3 = f4.isEqualTo(f2);

    System.out.println(String.format(
      "%s == %s returns %s",
      f1.toString(), f3.toString(), isEqual1
    ));
    System.out.println(String.format(
      "%s == %s returns %s",
      f1.toString(), f5.toString(), isEqual2
    ));

    System.out.println(String.format(
      "%s == %s returns %s",
      f4.toString(), f2.toString(), isEqual3
    ));
    System.out.println();

  }
}
