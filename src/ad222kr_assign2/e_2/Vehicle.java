package ad222kr_assign2.e_2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Vehicle {
  protected int _spaceRequired;
  protected int _passengerCost;
  protected int _vehicleCost;
  protected ArrayList<Passenger> _passengers;
  protected boolean _hasEmbarked;
  protected int _maxNumberOfPassengers;

  protected Vehicle(int spaceRequired, int passengerCost, int vehicleCost,
                    int maxNumberOfPassengers, int numberOfPassengers) {

    if (numberOfPassengers > maxNumberOfPassengers) {
      throw new IllegalArgumentException("The amount of passengers is to large for the vehicle");
    }
    _spaceRequired = spaceRequired;
    _passengerCost = passengerCost;
    _vehicleCost = vehicleCost;
    _hasEmbarked = false;
    _maxNumberOfPassengers = maxNumberOfPassengers;
    _passengers = new ArrayList<>(_maxNumberOfPassengers);

    for (int i = 1; i <= numberOfPassengers;i++) {
      addPassenger(new Passenger(_passengerCost));
    }
  }

  public int getSpaceRequired() {
    return _spaceRequired;
  }

  public int getPassengerCount() {
    return _passengers.size();
  }

  public int getCost() {
    return _vehicleCost;
  }

  public void disembark() {
    _hasEmbarked = false;
  }

  public void embark() {
    _hasEmbarked = true;
  }

  public List<Passenger> getPassengers() {
    return Collections.unmodifiableList(_passengers);
  }

  public boolean hasEmbarked() {
    return _hasEmbarked;
  }


  public void addPassenger(Passenger p) {
    if (isFull()) {
      throw new IndexOutOfBoundsException("The vehicle is full");
    }
    _passengers.add(p);
  }

  public void removePassenger(int index) {
    if (!isValidIndex(index)) {
      throw new IndexOutOfBoundsException(
        String.format(
          "Index out of bounds. Upper: %d, Attempted: %d",
          getPassengerCount() - 1, index
        )
      );
    }
    _passengers.remove(index);
  }

  private boolean isFull() {
    return _passengers.size() >= _maxNumberOfPassengers;
  }

  private boolean isValidIndex(int index) {
    return index >= 0 && index < getPassengerCount();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    int passengerCost = 0;
    for (Passenger p : _passengers) {
      passengerCost += p.getPrice();
    }

    sb.append(String.format("Vehicle type:                   %s\n", this.getClass().getSimpleName()));
    sb.append(String.format("Max no of passengers:           %d\n", _maxNumberOfPassengers));
    sb.append(String.format("Current no of passengers:       %d\n", getPassengerCount()));
    sb.append(String.format("Vehicle cost:                   %d\n", getCost()));
    sb.append(String.format("Passenger cost(per passenger):  %d\n", _passengerCost));
    sb.append(String.format("Total cost:                     %d\n", getCost() + passengerCost));


    return sb.toString();

  }


}
