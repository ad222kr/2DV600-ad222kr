package ad222kr_assign2.e_2;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by alex on 2016-09-12.
 */
public class Ferry implements IFerry {
  private static final int MAX_NUMBER_OF_PASSENGERS = 200;
  private static final int MAX_NUMBER_OF_VEHICLE_SPACE = 200;
  private ArrayList<Vehicle> _vehicles;
  private ArrayList<Passenger> _passengers;
  private int _vehicleSpaceTaken;
  private int _moneyEarned;

  public Ferry() {
    _vehicles = new ArrayList<>(MAX_NUMBER_OF_VEHICLE_SPACE); // Assume 200 bikes
    _passengers = new ArrayList<>(MAX_NUMBER_OF_PASSENGERS);
  }

  @Override
  public int countPassengers() {
    return _passengers.size();
  }

  @Override
  public int countVehicleSpace() {
    int space = 0;
    for (Vehicle vehicle : _vehicles) {
      space += vehicle.getSpaceRequired();
    }
    return space;
  }

  @Override
  public int countMoney() {
    // Would be better to name this method getEarnedMoney
    // The money is added when a vehicle and/or a passenger is embarked
    // else the money would be added again each time it is counted, and since
    // the requirements state that the money should not be reset when the ferry
    // disembarks, it is stored in a field.
    return _moneyEarned;
  }

  @Override
  public void embark(Vehicle v) {
    if (v.hasEmbarked()) {
      throw new IllegalStateException("The vehicle has already embarked and cannot embark again");
    }
    if (_vehicles.contains(v)) {
      throw new IllegalArgumentException("The car is already on the ferry");
    }
    if (!hasSpaceFor(v) || _passengers.size() + v.getPassengerCount() > MAX_NUMBER_OF_PASSENGERS) {
      // idk if the right exception
      throw new IndexOutOfBoundsException("There is no more room for a vehicle on the ferry");
    }
    _vehicles.add(v);
    _moneyEarned += v.getCost();
    v.embark();
    _vehicleSpaceTaken += v.getSpaceRequired();
    v.getPassengers().forEach(this::embark);

  }

  @Override
  public void embark(Passenger p) {
    if (_passengers.contains(p)) {
      throw new IllegalArgumentException("The passenger is already on the ferry");
    }
    if (!hasRoomFor(p)) {
      // idk if the right exception
      throw new IndexOutOfBoundsException("There is no more room for a person on the ferry");
    }
    _passengers.add(p);
    _moneyEarned += p.getPrice();
  }

  @Override
  public void disembark() {
    _passengers.clear();
    _vehicles.clear();
    _vehicleSpaceTaken = 0;
  }

  @Override
  public boolean hasSpaceFor(Vehicle v) {
    return _vehicleSpaceTaken + v.getSpaceRequired() <= MAX_NUMBER_OF_VEHICLE_SPACE;
  }

  @Override
  public boolean hasRoomFor(Passenger p) {
    return _passengers.size() < MAX_NUMBER_OF_PASSENGERS;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Ze ferry!\n");
    sb.append(String.format("Number of passengers: %d\n", countPassengers()));
    sb.append(String.format("Number of vehicles:   %d\n", _vehicles.size()));
    sb.append(String.format("Money earned:         %d\n", countMoney()));

    // Generates a lot of output on a full ferry. Uncomment to see it all
//    sb.append("Vehicles on the ferry:\n");
//    for (Vehicle v : this) {
//      sb.append(String.format(
//        "%s\n" +
//        "\tUnits of space taken: %d\n" +
//        "\tNumber of passengers: %d\n",
//        v.getClass().getSimpleName(), v.getSpaceRequired(), v.getPassengerCount()
//      ));
//    }
//    sb.append("\n");
    return sb.toString();
  }
  @Override
  public Iterator<Vehicle> iterator() {
    return new Iterator<Vehicle>() {
      private int currentIndex = 0;

      @Override
      public boolean hasNext() {
        return currentIndex < _vehicles.size() &&
               _vehicles.get(currentIndex++) != null;
      }

      @Override
      public Vehicle next() {
        return _vehicles.get(currentIndex++);
      }
    };
  }
}