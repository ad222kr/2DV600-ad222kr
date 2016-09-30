package ad222kr_assign3;

import graphs.DirectedGraph;
import graphs.GML;

/**
 * Created by alex on 30.9.16.
 */
public class MyGML<T> extends GML<T> {

  public MyGML(DirectedGraph<T> dg) {
    super(dg);
  }

  @Override
  public String toGML() {
    return null;
  }
}
