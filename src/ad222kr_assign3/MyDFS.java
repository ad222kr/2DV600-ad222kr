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



    List<Node<T>> toVisit = new ArrayList<>(); // To be visited next
    List<Node<T>> visited = new ArrayList<>(); // Already visited
    List<Node<T>> result = new ArrayList<>();


    toVisit.add(root);
    int num = 0; // WHY?
    while (!toVisit.isEmpty()) {
      Node<T> current = toVisit.remove(0);


      if (!visited.contains(current)) {
        current.num = num++;
        visited.add(current);
        result.add(current);
        for (Iterator<Node<T>> it = current.succsOf(); it.hasNext();) {
          Node<T> next = it.next();
          toVisit.add(0, next);
        }
      }
    }

    return result;
  }

  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph) {
    if (graph == null)
      throw new NullPointerException();

    List<Node<T>> toVisit = new ArrayList<>();
    List<Node<T>> visited = new ArrayList<>();
    List<Node<T>> result = new ArrayList<>();

    graph.heads().forEachRemaining(toVisit::add);

    int num = 0;
    while (!toVisit.isEmpty()) {
      Node<T> current = toVisit.remove(0);

      if (!visited.contains(current)) {
        current.num = num++;
        visited.add(current);
        result.add(current);
        for (Iterator<Node<T>> it = current.succsOf(); it.hasNext();) {
          Node<T> next = it.next();
          toVisit.add(0, next);
        }
      }
    }

    return result;


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
