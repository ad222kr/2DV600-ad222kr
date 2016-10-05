package ad222kr_assign3;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import com.sun.xml.internal.org.jvnet.fastinfoset.ExternalVocabulary;
import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by alex on 30.9.16.
 */
public class MyDFS<T> implements DFS<T> {

  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph, Node<T> root) {
    if (root == null || graph == null)
      throw new NullPointerException();

    List<Node<T>> bfsNodes = new ArrayList<>();
    //Set<Node<T>> visited = new HashSet<>();
    Node<T> node = graph.getNodeFor(root.item()); // make sure the node is actually in the graph
    dfs_recursive(bfsNodes, node /*, visited*/);
    return bfsNodes;

  }

  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph) {
    if (graph == null)
      throw new NullPointerException();

    List<Node<T>> bfsNodes = new ArrayList<>();
    // Using HashSet to store the visited nodes makes this so much faster..
    // but if the SIZE in benchmarks is over 166, it produces a StackOverflowError
    // not sure why..
    //Set<Node<T>> visited = new HashSet<>();

    if (graph.headCount() >= 1) {
      for (Iterator<Node<T>> it = graph.heads(); it.hasNext();) {
        dfs_recursive(bfsNodes, it.next()/*, visited*/);
      }
    }
    else
      dfs_recursive(bfsNodes, graph.getNodeFor(graph.allItems().get(0))/*, visited*/);


    return bfsNodes;

  }

  /**
   * A recursive approach to the depth first search algorithm
   * If the root parameter sent in is null, it starts the search
   * from the head nodes of the graph
   *
   * @param node     current node to check
   */
  private void dfs_recursive(List<Node<T>> bfsNodes, Node<T> node/*, Set<Node<T>> visited*/) {
    if (!bfsNodes.contains(node)) {
      //visited.add(node);
      bfsNodes.add(node);
      node.num = bfsNodes.size();
      //node.succsOf().forEachRemaining(s -> dfs_recursive(visited, s));
      for (Iterator<Node<T>> it = node.succsOf(); it.hasNext();) {
        dfs_recursive(bfsNodes, it.next()/*, visited*/);
      }
    }
  }

  /**
   * An iterative approach to the depth first search algorithm.
   * If the root parameter sent in is null, it starts searching
   * from the head nodes of the graph.
   *
   * @param   root  element to start at
   * @return        a List of all the nodes found
   */
//  private List<Node<T>> dfs_iterative(DirectedGraph<T> graph, Node<T> root) {
//
//    if (root == null) {
//      graph.heads().forEachRemaining(toVisit::add);
//    } else {
//      toVisit.add(root);
//    }
//
//    while (!toVisit.isEmpty()) {
//      Node<T> current = toVisit.remove(0);
//
//      if (!visited.contains(current)) {
//
//        visited.add(current);
//        current.num = visited.size();
//        current.succsOf().forEachRemaining(node -> toVisit.add(0, node));
//      }
//    }
//    return visited;
//  }




  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g, Node<T> root) {
    List<Node<T>> visited = new ArrayList<>();
    List<Node<T>> poList = new ArrayList<>();
    postOrder(root, visited, poList);
    return poList;
  }

  /**
   * Recursive traversing a
   *
   * @param node
   */
  private void postOrder(Node<T> node, List<Node<T>> visited, List<Node<T>> poList) {
    visited.add(node);

    for (Iterator<Node<T>> it = node.succsOf(); it.hasNext();) {
      Node<T> s = it.next();
      if (!visited.contains(s))
        postOrder(s, visited, poList);
    }
    node.num = poList.size() + 1;
    poList.add(node);
  }

  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g) {

    List<Node<T>> visited = new ArrayList<>();
    List<Node<T>> poList = new ArrayList<>();

    if (g.headCount() >= 1)
      g.heads().forEachRemaining(h -> postOrder(h, visited, poList));
    else
      postOrder(g.getNodeFor(g.allItems().get(0)), visited, poList);

    return poList;
  }

  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g, boolean attach_dfs_number) {
    return null;
  }

  @Override
  public boolean isCyclic(DirectedGraph<T> graph) {
    // TODO: implement a real(?) algortihm, preferably using the
    // topSort to check
    for (Node<T> node : postOrder(graph)) {
      for (Iterator<Node<T>> it = node.succsOf(); it.hasNext();) {
        // An edge src → tgt is a backward edge if Po(src) ≤ Po(tgt)
        if (node.num <= it.next().num)
          return true;
      }
    }
    // no backwards edges found
    return false;
  }

  @Override
  public List<Node<T>> topSort(DirectedGraph<T> graph) {
    // TODO: Implement a real topological sort algorithm
    // and use it to detect cycles as well...
    List<Node<T>> list = postOrder(graph);
    Collections.reverse(list);
    return list;

  }
}
