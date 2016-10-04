package ad222kr_assign3;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.List;

/**
 * Created by alex on 30.9.16.
 */
public class MyDFS<T> implements DFS<T> {
  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph, Node<T> root) {
    if (root == null)
      throw new NullPointerException("Root cannot be null");
    return null;
  }

  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph) {
    return null;
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
}
