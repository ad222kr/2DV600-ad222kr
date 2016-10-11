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

    return dfs_iterative(graph, root);

  }

  @Override
  public List<Node<T>> dfs(DirectedGraph<T> graph) {
    if (graph == null)
      throw new NullPointerException();

    return dfs_iterative(graph, null);

  }

  /**
   * An iterative approach to the depth first search algorithm.
   * If the root parameter sent in is null, it starts searching
   * from the head nodes of the graph.
   *
   * Similar to the BFS, but it keeps the elements to visit next in a stack
   * instead of a queue, since the deepest element should be added before its
   * "parents"
   *
   * Uses a HashSet to keep track of the already visisted elements for fast
   * lookup/contains.
   *
   * The result is added to the ArrayList dfsNodes
   *
   * @param   root  element to start at
   * @return        a List of all the nodes found
   */
  private List<Node<T>> dfs_iterative(DirectedGraph<T> graph, Node<T> root) {
    Stack<Node<T>> toVisit = new Stack<>(); //O(1)
    Set<Node<T>> visited = new HashSet<>(); //O(1)
    List<Node<T>> dfsNodes = new ArrayList<>(); //O(1)

    if (root != null)
      toVisit.add(root); //O(1)
    else if (graph.headCount() >= 1)
      graph.heads().forEachRemaining(toVisit::add);//O(n) worst case all nodes are Heads
    else
      toVisit.add(graph.getNodeFor(graph.allItems().get(0))); //O(1)

    while (!toVisit.isEmpty()) { // O(n) visit all nodes
      Node<T> node = toVisit.pop(); // O(1)

      if (!visited.contains(node)) { // O(1) HashSet contains is constant

        visited.add(node); // O(1)
        node.num = dfsNodes.size(); //O(1)
        dfsNodes.add(node); // O(1)
        node.succsOf().forEachRemaining(s -> {
          if (!visited.contains(s))
            toVisit.add(s);
        }); // O(S)
      }
    }
    return dfsNodes;
  }

  /**
   * A recursive approach to the depth first search algorithm
   * If the root parameter sent in is null, it starts the search
   * from the head nodes of the graph
   *
   * WARNING: This method can result in a StackOverflowError if
   * the graph has to many nodes since the callstack will exceed
   * the size of the stack..
   *
   * @param node     current node to check
   */
  private void dfs_recursive(List<Node<T>> bfsNodes, Node<T> node, Set<Node<T>> visited) {

    if (!visited.contains(node)) {
      visited.add(node);
      bfsNodes.add(node);
      node.num = bfsNodes.size();
      for (Iterator<Node<T>> it = node.succsOf(); it.hasNext();) {
        dfs_recursive(bfsNodes, it.next(), visited);
      }
    }
  }

  @Override
  public List<Node<T>> postOrder(DirectedGraph<T> g, Node<T> root) {
    Set<Node<T>> visited = new HashSet<>();
    List<Node<T>> poList = new ArrayList<>();
    postOrder(root, visited, poList);
    return poList;
  }

  /**
   * Recursive approach to a postOrder sorting.
   *
   *
   *
   * @param node
   */
  private void postOrder(Node<T> node, Set<Node<T>> visited, List<Node<T>> poList) {
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

    Set<Node<T>> visited = new HashSet<>();
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
