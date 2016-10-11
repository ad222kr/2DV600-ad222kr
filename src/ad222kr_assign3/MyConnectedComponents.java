package ad222kr_assign3;

import graphs.ConnectedComponents;
import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by alex on 30.9.16.
 */
public class MyConnectedComponents<T> implements ConnectedComponents<T> {
  /**
   * Assuming the definition of a connected component here is not a strong one, i.e.
   *
   * Strong component [A -> B, B -> C, C -> A], all nodes reachable from every node
   *   A
   * /   \
   * B - C
   *
   * or
   *
   * A <=> B <=> C [A -> B, B -> A, B -> C, C - B]
   *
   * but searches for components like these
   *
   * "Weak" component, all elements are connected by paths, direction not relevant
   * A <- B -> C [B -> A, B -> C]
   *
   * or
   *
   * A -> B -> C -> D [A -> B, B -> C, C -> D]
   *
   * Preforms a search for connected components in a digraph.
   *
   * Uses a depth first search approach go through each node and check what nodes
   * can be reached from it. To avoid searching every node, a HashSet keeps track
   * of the visited node.
   * If A -> B -> C -> D is found on a dfs of the first node, there is no need to
   * make a dfs on B, C, and D since they are alerady found and it would be a waste of time.
   *
   * If two components contain the same element after the search, they are merged together
   * since they are by definition connected. For example, we found
   * 4 -> 5  and later on picked up 6 -> 5 from another DFS, these should be one component.
   *
   * @param   dg The graph to look for components in
   * @return  A collection of collections containing the nodes that are connected
   */
  @Override
  public Collection<Collection<Node<T>>> computeComponents(DirectedGraph<T> dg) {
    DFS<T> myDFS = new MyDFS<T>();
    Set<Node<T>> visited = new HashSet<>();
    Set<Collection<Node<T>>> components = new HashSet<>();

    for (Node<T> node : dg) {
      // Create a "component" for each node
      Set<Node<T>> component  = new HashSet<>();
      if (!visited.contains(node)) {
        // add the node to the component and mark it visited
        visited.add(node);
        component.add(node);

        // get all nodes reachable from this node
        Collection<Node<T>> reachable = myDFS.dfs(dg, node);
        for (Node<T> r : reachable) {
          component.add(r);
          visited.add(r); // do not visit every node with dfs, takes to much time
        }
      }

      for (Collection<Node<T>> c : components) {
        // check if 2 components share some elements,
        // in that case they need to be merged since they are
        // are connected but wasn't picked up by the dfs
        if (!Collections.disjoint(c, component)) {
          // Sometimes a dfs will pick up 2 "components" that might share elements,
          // i.e. 4 -> 5 and 6 -> 5, 4 -> 5 <- 6
          // therefor we need to merge them and then clear the component so it is
          // empty for the empty check below
          c.addAll(component);
          component.clear();
        }
      }

      if (!component.isEmpty())
        components.add(component);
    }

    return components;
  }


}
