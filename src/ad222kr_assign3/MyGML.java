package ad222kr_assign3;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toMap;

/**
 * Created by alex on 30.9.16.
 */
public class MyGML<T> extends GML<T> {

  public MyGML(DirectedGraph<T> dg) {
    super(dg);
  }

  @Override
  public String toGML() {

    StringBuilder sb = new StringBuilder();
    sb.append("graph [\n");
    for (T item : graph.allItems()) {
      Node<T> node = graph.getNodeFor(item);
      sb.append("\tnode [\n");
      sb.append(String.format("\t\tid %d\n", item));
      sb.append(String.format("\t\tlabel \"node no %d\"\n", item));
      sb.append(String.format("\t\tisHead \"%s\"\n", node.isHead()));
      sb.append(String.format("\t\tisTail \"%s\"\n", node.isTail()));
      sb.append("\t]\n");
    }

    for (T item : graph.allItems()) {
      Node<T> node = graph.getNodeFor(item);

      Iterator<Node<T>> it = node.succsOf();
        while (it.hasNext()) {
          Node<T> next = it.next();
          sb.append("\tedge [\n");
          sb.append(String.format("\t\tsource %d\n", item));
          sb.append(String.format("\t\ttarget %d\n", next.item()));
          sb.append(String.format("\t\tlabel \"Edge from node %d to node %d\"\n", item, next.item()));
          sb.append("\t]\n");
        }

    }

    sb.append("]");
    return sb.toString();
  }
}
