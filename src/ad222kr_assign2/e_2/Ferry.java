package ad222kr_assign2.e_2;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by alex on 2016-09-12.
 */
public class Ferry implements IFerry {
  private static final int MAX_NUMBER_OF_PASSENGERS = 200;
  private ArrayList<Vehicle> _vehicles;
  private ArrayList<Passenger> _passengers;
  private int _spaceLeft = 200; // In terms of bikes. 40 cars. 1 car = 5 bikes
  private int _moneyEarned;

  public Ferry() {
    _vehicles = new ArrayList<>(_spaceLeft);
    _passengers = new ArrayList<>(MAX_NUMBER_OF_PASSENGERS);
  }

  public double getMoneyEarned() {
    return _moneyEarned;
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
    // This method counts the money for the vehicles currently on the ferry
    // This is how i interpreted the assignment, since the money should not
    // be cleared on disembarking, it has to be held in a field and added each
    // time a vehicle/passenger is embarked.

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
    if (!hasSpaceFor(v)) {
      // idk if the right exception
      throw new IllegalStateException("There is no more room for a vehicle on the ferry");
    }
    _vehicles.add(v);
    _moneyEarned += v.getCost();
    v.embark();
    v.getPassengers().forEach(this::embark);

  }

  @Override
  public void embark(Passenger p) {
    if (_passengers.contains(p)) {
      throw new IllegalArgumentException("The passenger is already on the ferry");
    }
    if (!hasRoomFor(p)) {
      // idk if the right exception
      throw new IllegalStateException("There is no more room for a person on the ferry");
    }
    _passengers.add(p);
    _moneyEarned += p.getPrice();
  }

  @Override
  public void disembark() {
    _passengers.clear();
    _vehicles.clear();
  }

  @Override
  public boolean hasSpaceFor(Vehicle v) {
    return _spaceLeft - v.getSpaceRequired() >= 0;
  }

  @Override
  public boolean hasRoomFor(Passenger p) {
    return _passengers.size() < MAX_NUMBER_OF_PASSENGERS;
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