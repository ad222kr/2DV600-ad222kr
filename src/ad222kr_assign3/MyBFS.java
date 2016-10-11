package ad222kr_assign3;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by alex on 30.9.16.
 */
public class MyBFS<T> implements BFS<T> {

  @Override
  public List<Node<T>> bfs(DirectedGraph<T> graph, Node<T> root) {
    return bfs_iterative(graph, root);
  }

  @Override
  public List<Node<T>> bfs(DirectedGraph<T> graph) {
    return bfs_iterative(graph, null);

  }

  /**
   * Private method for a breadth first search, not exposed to the outside but used in
   * the public interface of this class.
   *
   * Searches a directed graph breadth first. If no root element is supplied, start
   * att one of the heads. If the graph contains no heads, i.e. is cyclic, start at a
   * random node and work around it.
   *
   * This algorithm uses a LinkedList acting as a Queue for keeping track of the elements
   * to visit next.
   *
   * A HashSet is used to keep track of the already visisted elements for fast lookup/contains.
   * The element that is currently searched is added to the results ArrayList called bfsNodes,
   * after that the successors of this node are queued for visitation.
   *
   *
   * @param graph a DirectedGraph<T> to search
   * @param root the root element to start
   * @return
   */
  private List<Node<T>> bfs_iterative(DirectedGraph<T> graph, Node<T> root) {

    Queue<Node<T>> toVisit = new LinkedList<>(); // LinkedList, acting as a queue for fast insert/delete
    Set<Node<T>> visited = new HashSet<>();
    ArrayList<Node<T>> bfsNodes = new ArrayList<>();

    if (root != null) {
      toVisit.add(root);
    } else if(graph.headCount() >= 1) {
      graph.heads().forEachRemaining(toVisit::add);

    } else {
      toVisit.add(graph.getNodeFor(graph.allItems().get(0)));
    }

    while (!toVisit.isEmpty()) {
      Node<T> current = toVisit.remove();

      if (!visited.contains(current)) {
        visited.add(current);
        bfsNodes.add(current);
        current.num = visited.size();
        current.succsOf().forEachRemaining(s -> {
          if (!visited.contains(s))
            toVisit.add(s);
        });
      }
    }

    return bfsNodes;
  }
}
