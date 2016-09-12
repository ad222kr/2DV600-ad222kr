package ad222kr_assign2.e_2;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by alex on 2016-09-12.
 */
public abstract class Vehicle {
  protected int _spaceRequired;
  protected double _passengerCost;
  protected double _vehicleCost;
  protected ArrayList<Passenger> _passengers;
  protected boolean _hasEmbarked;
  protected int _maxNumberOfPassengers;

  protected Vehicle(int spaceRequired, double passengerCost, double vehicleCost,
                    int maxNumberOfPassengers) {
    _spaceRequired = spaceRequired;
    _passengerCost = passengerCost;
    _vehicleCost = vehicleCost;
    _hasEmbarked = false;
    _maxNumberOfPassengers = maxNumberOfPassengers;
    _passengers = new ArrayList<>(_maxNumberOfPassengers);
  }


}
