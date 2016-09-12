package ad222kr_assign2.e_2;

import java.util.Iterator;

/**
 * Created by alex on 2016-09-12.
 */
public class Ferry implements IFerry {
  private Vehicle[] _vehicles;
  private Passenger[] _passengers;
  private int spaceLeft = 40;
  @Override
  public int countPassengers() {
    return _passengers.length;
  }

  @Override
  public int countVehicleSpace() {
    return _vehicles.length;
  }

  @Override
  public int countMoney() {
    return 0;
  }

  @Override
  public void embark(Vehicle v) {

  }

  @Override
  public void embark(Passenger p) {

  }

  @Override
  public void disembark() {

  }

  @Override
  public boolean hasSpaceFor(Vehicle v) {
    return false;
  }

  @Override
  public boolean hasRoomFor(Passenger p) {
    return false;
  }

  @Override
  public Iterator<Vehicle> iterator() {
    return new Iterator<Vehicle>() {
      private int currentIndex = 0;

      @Override
      public boolean hasNext() {
        return currentIndex < _vehicles.length && _vehicles[currentIndex] != null;
      }

      @Override
      public Vehicle next() {
        return _vehicles[currentIndex++];
      }
    };
  }
}
