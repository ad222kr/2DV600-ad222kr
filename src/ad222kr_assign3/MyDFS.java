package ad222kr_assign3;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by alex on 30.9.16.
 */
public class MyDFS<T> implements DFS<T> {

  /**
   * counter for post order traversal
   */
  private int poCounter = 1;

  /**
   * Holds the nodes that have been visited by a traverse
   */
  private List<Node<T>> visited = new ArrayList<>();


  /**
   * Holds the nodes that are up next to visit
   */
  private List<Node<T>> toVisit = new ArrayList<>(); // To be visited next


  /**
   * Holds the nodes that have been traversed with postordering
   */
  private List<Node<T>> postOrderList = new ArrayList<>();

  private void resetDFS() {
    poCounter = 1;
    visited.clear();
    toVisit.clear();
    postOrderList.clear();
  }

  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph, Node<T> root) {
    if (root == null || graph == null)
      throw new NullPointerException();

    resetDFS();
    boolean useRecursion = true;

    if (useRecursion) {
      dfs_recursive(graph, root);
      return visited;
    } else {
      return dfs_iterative(graph, root);
    }
  }

  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph) {
    if (graph == null)
      throw new NullPointerException();

    resetDFS();
    boolean useRecursion = true;

    if (useRecursion) {
      dfs_recursive(graph, null);
      return visited;
    } else {
      return dfs_iterative(graph, null);
    }
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
        current.succsOf().forEachRemaining(node -> toVisit.add(0, node));
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
   */
  private void dfs_recursive(DirectedGraph<T> graph, Node<T> node) {
    if (node == null) {
      // No root node to start searching from,
      // use the head nodes as starting point!
      graph.heads().forEachRemaining(n -> {
        if (!visited.contains(n)) {
          visited.add(n);
          n.num = visited.size();
          n.succsOf().forEachRemaining(s -> dfs_recursive(graph, s));
        }
      });
    } else {
      if (!visited.contains(node)) {
        visited.add(node);
        node.num = visited.size();
        node.succsOf().forEachRemaining(s -> dfs_recursive(graph, s));
      }
    }
  }

  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g, Node<T> root) {
    resetDFS();
    postOrder(root);
    return postOrderList;
  }

  /**
   * Recursive traversing a
   *
   * @param node
   */
  private void postOrder(Node<T> node) {
    visited.add(node);

    for (Iterator<Node<T>> it = node.succsOf(); it.hasNext();) {
      Node<T> s = it.next();
      if (!visited.contains(s))
        postOrder(s);
    }
    node.num = poCounter++;
    postOrderList.add(node);
  }

  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g) {
    resetDFS();
    g.heads().forEachRemaining(toVisit::add);

    for (Node<T> n : toVisit) {
      postOrder(n);
    }

    return postOrderList;
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

  private void visitForTopSort(Node<T> node, List<Node<T>> tempMarked,
                               List<Node<T>> visited, List<Node<T>> sorted) {

  }



}
