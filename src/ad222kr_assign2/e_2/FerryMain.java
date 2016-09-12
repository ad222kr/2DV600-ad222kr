package ad222kr_assign2.e_2;

/**
 * Created by alex on 2016-09-12.
 */
public class FerryMain {
  public static void main(String[] args) {
    Car car = new Car(3);
    System.out.println(car.toString());
    Passenger p = new Passenger();
    System.out.println(p.toString());
    car.addPassenger(p);
    System.out.println(car.toString());
  }

}
