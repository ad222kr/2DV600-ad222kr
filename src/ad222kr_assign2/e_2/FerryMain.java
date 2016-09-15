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

    // embarking a ferry with 200 passengers
    for (int i = 1; i <= 200; i++) {
      ferry.embark(new Passenger());
    }

    System.out.println("1. Embarked 200 passengers..");
    System.out.println("Ferry looks like this now: ");
    System.out.println("\t" + ferry.toString());
    System.out.println("Ferry.hasRoomFor(Passenger p):" + ferry.hasRoomFor(new Passenger()));
    System.out.println("Ferry.hasSpaceFor(Vehicle p):" + ferry.hasSpaceFor(new Car(3)));
    System.out.println();

    System.out.println("2. Try to embark another passengers");
    try {
      ferry.embark(new Passenger());
    } catch (Exception e) {
      System.out.println("\tException thrown");
      System.out.println("\tMessage: " + e.getMessage());
    }


    System.out.println();

    ferry.disembark();
    System.out.println("3. Disembarked ferry");
    System.out.println("Ferry looks like this now: ");
    System.out.println("\t" + ferry.toString());

    System.out.println("4. Embarking 200 bikes");

    for (int i = 1; i <= 200; i++) {
      ferry.embark(new Bicycle());
    }
    System.out.println("Ferry looks like this now: ");
    System.out.println("\n" + ferry.toString());
    System.out.println("Ferry.hasRoomFor(Passenger p):" + ferry.hasRoomFor(new Passenger()));
    System.out.println("Ferry.hasSpaceFor(Vehicle p):" + ferry.hasSpaceFor(new Car(3)));

    System.out.println("5. Try to embark another bike");
    try {
      ferry.embark(new Bicycle());
    } catch (Exception e) {
      System.out.println("\tCaught Exception");
      System.out.println("\t" + e.getMessage());
    }

    ferry.disembark();
    System.out.println(ferry.toString());

    System.out.println("6. Try to add Vehicles and Pasengers already on the ferry");
    Passenger p = new Passenger();
    Vehicle v = new Lorry(2);
    ferry.embark(p);
    ferry.embark(v);

    try {
      ferry.embark(p);
    } catch (Exception e) {
      System.out.println("\tException Caught");
      System.out.println("\tMessage: " + e.getMessage());
    }


    try {
      ferry.embark(v);
    } catch (Exception e) {
      System.out.println("\tException Caught");
      System.out.println("\tMessage: " + e.getMessage());
    }

    ferry.disembark();
    System.out.println("7. Embark a vehicle that has already been embarked before");
    try {
      ferry.embark(v);
    } catch (Exception e) {
      System.out.println("\tException caught");
      System.out.println("\tMessage: " + e.getMessage());
    }

    System.out.println("8. Maiden voyage of the ferry");
    ferry.disembark();
    System.out.println("\tAdding some vehicles... 5 cars, 15 bikes, 2 lorrys and 3 buses");
    for (int i = 1; i <= 5; i++) {
      ferry.embark(new Car(4));
    }
    for (int i = 1; i <= 15; i++) {
      ferry.embark(new Bicycle());
    }
    ferry.embark(new Lorry(2));
    ferry.embark(new Lorry(1));
    for (int i = 1; i <= 3; i++) {
      ferry.embark(new Bus(15));
    }
    System.out.println("\tAdding some passengers.. 40 of them");
    for (int i = 1; i <= 40; i++) {
      ferry.embark(new Passenger());
    }
    System.out.println("Ferry looks like this: ");
    System.out.println(ferry.toString());

    System.out.println("9. Try to add to many passengers to a vehicle");

    try {
      System.out.println("\t Car with 5 passengers");
      new Car(5);
    } catch (Exception e) {
      System.out.println("\tCaught exception: " + e.getMessage());
    }

    try {
      System.out.println("\t Lorry with 3 passengers");
      new Lorry(3);
    } catch (Exception e) {
      System.out.println("\tCaught exception: " + e.getMessage());
    }

    try {
      System.out.println("\t Bus with 50 passengers");
      new Bus(50);
    } catch (Exception e) {
      System.out.println("\tCaught exception: " + e.getMessage());
    }

    System.out.println("10. Vehicle.toString()");
    Vehicle car = new Car(3);
    System.out.println(car.toString());
  }
}
