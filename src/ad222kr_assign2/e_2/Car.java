package ad222kr_assign2.e_2;

/**
 * Created by alex on 2016-09-12.
 */
public class Car extends Vehicle {
  private final static int SPACE_REQUIRED = 5;
  private final static int PASSENGER_COST = 15;
  private final static int VEHICLE_COST = 100;
  private final static int MAX_NUMBER_OF_PASSENGERS = 4;

  public Car(int passengerCount) {
    super(
      SPACE_REQUIRED, PASSENGER_COST, VEHICLE_COST,
      MAX_NUMBER_OF_PASSENGERS, passengerCount
    );
  }

}
