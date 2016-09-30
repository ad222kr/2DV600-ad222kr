package ad222kr_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by alex on 30.9.16.
 */
public class MyGraph<T> implements DirectedGraph<T> {
  private Map<T, Node<T>> nodes;
  private Set<Node<T>> heads;
  private Set<Node<T>> tails;

  public MyGraph() {
    nodes = new HashMap<>();
    heads = new HashSet<>();
    tails = new HashSet<>();
  }
  @Override
  public Node<T> addNodeFor(T item) {
    if (item == null)
      throw new NullPointerException("Node cannot be null");

    MyNode<T> node = new MyNode<>(item);
    
    if (!nodes.containsKey(item)) {
      nodes.put(item, node);
      heads.add(node);
      tails.add(node);
    }


    return node;
  }

  @Override
  public Node<T> getNodeFor(T item) {
    if (item == null) {
      throw new NullPointerException("Item cannot be null");
    }

    if (nodes.containsKey(item)) {
      throw new NoSuchElementException("No such item in the grapsh");
    }

    return nodes.get(item);
  }

  @Override
  public boolean addEdgeFor(T from, T to) {
    if (from == null || to == null) {
      throw new NullPointerException("The items cannot be null");
    }

    Node<T> source = addNodeFor(from);
    Node<T> target = addNodeFor(to);



  }

  @Override
  public boolean containsNodeFor(T item) {
    return nodes.containsKey(item);
  }

  @Override
  public int nodeCount() {
    return nodes.size();
  }

  @Override
  public Iterator<Node<T>> iterator() {
    return nodes.values().iterator();
  }

  @Override
  public Iterator<Node<T>> heads() {
    return heads.iterator();
  }

  @Override
  public int headCount() {
    return heads.size();
  }

  @Override
  public Iterator<Node<T>> tails() {
    return tails.iterator();
  }

  @Override
  public int tailCount() {
    return tails.size();
  }

  @Override
  public List<T> allItems() {
   return new ArrayList<>(nodes.keySet());
  }

  @Override
  public int edgeCount() {
    return 0;
  }

  @Override
  public void removeNodeFor(T item) {

  }

  @Override
  public boolean containsEdgeFor(T from, T to) {
    return false;
  }

  @Override
  public boolean removeEdgeFor(T from, T to) {
    return false;
  }
}
