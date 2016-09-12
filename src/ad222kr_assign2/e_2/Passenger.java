package ad222kr_assign2.e_2;

/**
 * Created by alex on 2016-09-12.
 */
public class Passenger {
  private static final double PASSENGER_WITHOUT_VEHICLE_TICKET_PRICE = 20.0;
  private double _ticketPrice;

  public Passenger() {
    this(PASSENGER_WITHOUT_VEHICLE_TICKET_PRICE);
  }

  public Passenger(double ticketPrice) {
    _ticketPrice = ticketPrice;
  }


  public double getPrice() {
    return _ticketPrice;
  }

  @Override
  public String toString() {
    return String.format(
      "Passenger details:\n\tTicket price: %.2f",
       _ticketPrice
    );
  }
}
