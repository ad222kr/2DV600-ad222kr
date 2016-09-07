package ad222kr_assign1.e_7_to_13.point;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by alex on 2016-09-07.
 */
public class Point {

  private int _x;
  private int _y;

  public Point() {
    // empty!
    _x = 0;
    _y = 0;
  }

  public Point(int x, int y) {
    _x = x;
    _y = y;
  }

  public boolean isEqualTo(Point other) {
    return _x == other.getX() && _y == other.getY();
  }


  public double distanceTo(Point other) {
    return Math.sqrt(Math.pow(_x - other.getX(), 2) + Math.pow(_y - other.getY(), 2));
  }

  public void move(int xDif, int yDif) {
    _x += xDif;
    _y += yDif;
  }

  public void moveToXY(int toX, int toY) {
    _x = toX;
    _y = toY;
  }

  public int getX() {
    return _x;
  }

  public int getY() {
    return _y;
  }

  @Override
  public String toString() {
    return String.format("(%1d, %2d)", _x, _y);
  }
}
