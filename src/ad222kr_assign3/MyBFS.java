package ad222kr_assign3;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    List<Node<T>> toVisit = new ArrayList<>();
    List<Node<T>> visited = new ArrayList<>();

    if (root == null) {
      graph.heads().forEachRemaining(toVisit::add);
    } else {
      toVisit.add(root);
    }

    while (!toVisit.isEmpty()) {
      Node<T> current = toVisit.remove(0);
      if (!visited.contains(current)) {
        visited.add(current);
        current.num = visited.size();
        current.succsOf().forEachRemaining(toVisit::add);
      }

    }
    return visited;
  }
}
