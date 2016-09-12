package ad222kr_assign2.e_2;

import java.util.ArrayList;

/**
 * Created by alex on 2016-09-12.
 */
public abstract class Vehicle {
  private ArrayList<Passenger> _passengers;

  public Vehicle() {
    _passengers = new ArrayList<>(getMaxNumberOfPassengers());
  }

  public abstract int getMaxNumberOfPassengers();
}
