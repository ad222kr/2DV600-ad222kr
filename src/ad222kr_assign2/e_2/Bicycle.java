package ad222kr_assign2.e_2;

/**
 * Created by alex on 2016-09-12.
 */
public class Bicycle extends Vehicle{
  private final static int SPACE_REQUIRED = 1;
  private final static int PASSENGER_COST = 0;
  private final static int VEHICLE_COST = 40; // passenger + bike
  private final static int MAX_NUMBER_OF_PASSENGERS = 1;

  public Bicycle() {
    super(
      SPACE_REQUIRED, PASSENGER_COST, VEHICLE_COST,
      MAX_NUMBER_OF_PASSENGERS, 1
    );
  }
}
