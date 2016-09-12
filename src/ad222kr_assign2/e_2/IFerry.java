package ad222kr_assign2.e_2;

/**
 * Created by alex on 2016-09-12.
 */
public interface IFerry extends Iterable<Vehicle> {
  int countPassengers();
  int countVehicleSpace();
  int countMoney();
  void embark(Vehicle v);
  void embark(Passenger p);
  void disembark();

  boolean hasSpaceFor(Vehicle v);
  boolean hasRoomFor(Passenger p);
  String toString();

}
