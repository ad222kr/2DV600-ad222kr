package ad222kr_assign2.e_2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Vehicle {
  protected int _spaceRequired;
  protected double _passengerCost;
  protected double _vehicleCost;
  protected ArrayList<Passenger> _passengers;
  protected boolean _hasEmbarked;
  protected int _maxNumberOfPassengers;

  protected Vehicle(int spaceRequired, double passengerCost, double vehicleCost,
                    int maxNumberOfPassengers, int numberOfPassengers) {
    _spaceRequired = spaceRequired;
    _passengerCost = passengerCost;
    _vehicleCost = vehicleCost;
    _hasEmbarked = false;
    _maxNumberOfPassengers = maxNumberOfPassengers;
    _passengers = new ArrayList<Passenger>(_maxNumberOfPassengers);

    for (int i = 1; i <= numberOfPassengers;i++) {
      _passengers.add(new Passenger(_passengerCost));
    }
  }

  public int getPassengerCount() {
    return _passengers.size();
  }

  public double getTotalCost() {
    return _vehicleCost + _passengerCost * _passengers.size();
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
    if (!isCorrectindex(index)) {
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

  private boolean isCorrectindex(int index) {
    return index >= 0 && index < getPassengerCount();
  }

  @Override
  public String toString() {
    return String.format(
      "Vehicle type: %s. \n" +
        "\tNo of passengers: %d.\n" +
        "\tMax number of passengers: %d\n" +
        "\tTotal cost: %.2f kr\n",
      getClass().getSimpleName(), getPassengerCount(), _maxNumberOfPassengers, getTotalCost()
    );
  }



}
