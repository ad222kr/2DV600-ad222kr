package ad222kr_assign2.e_2;

/**
 * Created by alex on 2016-09-13.
 */
public class Bus extends Vehicle {
  private static final int SPACE_REQUIRED = 20;
  private static final int PASSENGER_COST = 10;
  private static final int VEHICLE_COST = 200;
  private static final int MAX_NUMBER_OF_PASSENGERS = 20;

  public Bus(int numberOfPassengers) {
    super(
      SPACE_REQUIRED, PASSENGER_COST, VEHICLE_COST,
      MAX_NUMBER_OF_PASSENGERS, numberOfPassengers
    );
  }
}
