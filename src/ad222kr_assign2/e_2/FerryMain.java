package ad222kr_assign2.e_2;

/**
 * Cheat sheet for prices and space requirements
 *
 * Vehicle Space       Name           Price
 *                     Passenger      20kr
 * 1 unit              Bicycle        40kr (passenger included)
 * 5 units             Car            100kr + 15kr/passenger (max 4 passengers)
 * 20                  Bus            200kr + 10kr/passenger (max 20 passengers)
 * 40                  Lorry          300kr + 15kr/passenger (max 2 passengers)
 *
 *
 */
public class FerryMain {
  public static void main(String[] args) {
    IFerry ferry = new Ferry();

    for (int i =  1; i <= 40; i++) {
      ferry.embark(new Car(4));
    }

    System.out.println(ferry.countPassengers());
    System.out.println(ferry.countVehicleSpace());
    System.out.println(ferry.toString());
    System.out.println(ferry.countMoney());

    ferry.disembark();
    System.out.println(ferry.countMoney());

    for (int i = 1; i <= 200; i++) {
      ferry.embark(new Passenger());
    }

    System.out.println(ferry.countMoney());
  }
}
