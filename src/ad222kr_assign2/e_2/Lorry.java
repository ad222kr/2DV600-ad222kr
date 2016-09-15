package ad222kr_assign2.e_2;

/**
 * Created by alex on 2016-09-14.
 */
public class Lorry extends Vehicle {
  private final static int SPACE_REQUIRED = 40;
  private final static int PASSENGER_COST = 15;
  private final static int VEHICLE_COST = 300;
  private final static int MAX_NUMBER_OF_PASSENGERS = 2;

  public Lorry(int passengerCount) {
    super(
      SPACE_REQUIRED, PASSENGER_COST, VEHICLE_COST,
      MAX_NUMBER_OF_PASSENGERS, passengerCount
    );
  }
}
