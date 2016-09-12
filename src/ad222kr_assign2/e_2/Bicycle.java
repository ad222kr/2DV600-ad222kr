package ad222kr_assign2.e_2;

/**
 * Created by alex on 2016-09-12.
 */
public class Bicycle {
  private Passenger _passenger;
  private double _cost;
  private int _space;

  public Bicycle(Passenger passenger) {
    _passenger = passenger;
    _cost = 40.0;
    _space = 1;
  }

  public Passenger getPassenger() {
    return _passenger;
  }

  public double getCost() {
    return _cost;
  }
}
