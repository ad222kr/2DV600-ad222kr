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
  private List<Node<T>> bfs_iterative(DirectedGraph<T> graph, Node<T> root) {
    // Linked list since it is much faster att adding/removing elements
    Queue<Node<T>> toVisit = new LinkedList<>(); //47 sek linked list, arraylist slow
    Set<Node<T>> visited = new HashSet<>(); // 23 sek hashSet
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
        current.succsOf().forEachRemaining(toVisit::add);
      }

    }

    return bfsNodes;
  }
}
