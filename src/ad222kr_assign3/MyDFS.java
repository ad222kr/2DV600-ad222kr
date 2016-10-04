package ad222kr_assign3;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alex on 30.9.16.
 */
public class MyDFS<T> implements DFS<T> {
  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph, Node<T> root) {
    if (root == null || graph == null)
      throw new NullPointerException();

    boolean useRecursion = false;

    if (useRecursion) {
      ArrayList<Node<T>> visited = new ArrayList<>();
      return dfs_recursive(graph, root, visited);
    } else {
      return dfs_iterative(graph, root);
    }
  }

  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph) {
    if (graph == null)
      throw new NullPointerException();

    boolean useRecursion = false;

    if (useRecursion) {
      ArrayList<Node<T>> visited = new ArrayList<>();
      return dfs_recursive(graph, null, visited);
    } else {
      return dfs_iterative(graph, null);
    }

  }



  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g, Node<T> root) {
    return null;
  }

  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g) {
    return null;
  }

  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g, boolean attach_dfs_number) {
    return null;
  }

  @Override
  public boolean isCyclic(DirectedGraph<T> graph) {
    return false;
  }

  @Override
  public List<Node<T>> topSort(DirectedGraph<T> graph) {
    return null;
  }

  /**
   * An iterative approach to the depth first search algorithm.
   * If the root parameter sent in is null, it starts searching
   * from the head nodes of the graph.
   *
   * @param   graph the Graph to searh
   * @param   root  element to start at
   * @return        a List of all the nodes found
   */
  private List<Node<T>> dfs_iterative(DirectedGraph<T> graph, Node<T> root) {
    List<Node<T>> toVisit = new ArrayList<>(); // To be visited next
    List<Node<T>> visited = new ArrayList<>(); // Already visited

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
        for (Iterator<Node<T>> it = current.succsOf(); it.hasNext();) {
          Node<T> next = it.next();
          toVisit.add(0, next);
        }
      }
    }
    return visited;
  }


  /**
   * A recursive approach to the depth first search algorithm
   * If the root parameter sent in is null, it starts the search
   * from the head nodes of the graph
   *
   * @param graph    the graph to search
   * @param node     current node to check
   * @param visited  array containing the visited elements, to keep track of em
   * @return         a List containing all nodes when the recursion is done
   */
  private List<Node<T>> dfs_recursive(DirectedGraph<T> graph, Node<T> node, ArrayList<Node<T>> visited) {
    // TODO: clean up dry
    if (node == null) {
      graph.heads().forEachRemaining(n -> {
        if (!visited.contains(n)) {
          visited.add(n);
          n.num = visited.size();
          n.succsOf().forEachRemaining(s -> dfs_recursive(graph, s, visited));
        }
      });
    } else {
      if (!visited.contains(node)) {
        visited.add(node);
        node.num = visited.size();
        node.succsOf().forEachRemaining(s -> dfs_recursive(graph, s, visited));
      }
    }
    return visited;
  }
}
