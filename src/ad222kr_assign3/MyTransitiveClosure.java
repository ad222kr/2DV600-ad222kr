package ad222kr_assign3;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;


/**
 * Created by alex on 30.9.16.
 */
public class MyTransitiveClosure<T> implements TransitiveClosure<Integer> {
  @Override
  public Map<Node<Integer>, Collection<Node<Integer>>> computeClosure(DirectedGraph<Integer> dg) {
    Map<Node<Integer>, Collection<Node<Integer>>> closures = new HashMap<>();
    MyDFS<Integer> dfs = new MyDFS<>();

    for (Iterator<Node<Integer>> it = dg.iterator(); it.hasNext();) {
      Node<Integer> n = it.next();
      List<Node<Integer>> l = dfs.dfs(dg, n);
      closures.put(n, l);
    }

    return closures;
  }
}
