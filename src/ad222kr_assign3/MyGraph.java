package ad222kr_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by alex on 30.9.16.
 */
public class MyGraph<T> implements DirectedGraph<T> {
  /**
   * HashMap containing all the nodes in the graph
   */
  private Map<T, Node<T>> nodes;

  /**
   * HashSet containing all the head nodes
   * A node is a head if it has no edges pointing to it
   */
  private Set<Node<T>> heads;


  /**
   * HashSet containing all the tail nodes
   * A node is a tail if it has no edges growing out of it
   */
  private Set<Node<T>> tails;

  /**
   * Instantiates a new instance of the MyGraph class
   */
  public MyGraph() {
    nodes = new HashMap<>();
    heads = new HashSet<>();
    tails = new HashSet<>();

  }
  @Override
  public Node<T> addNodeFor(T item) {
    if (item == null)
      throw new NullPointerException("Node cannot be null");

    if (containsNodeFor(item))
      return nodes.get(item);

    MyNode<T> node = new MyNode<>(item);
    nodes.put(item, node);
    heads.add(node);
    tails.add(node);
    return node;
  }

  @Override
  public Node<T> getNodeFor(T item) {
    if (!containsNodeFor(item))
      throw new NoSuchElementException();

    return nodes.get(item);
  }

  @Override
  public boolean addEdgeFor(T from, T to) {
    if (containsEdgeFor(from, to)) {
      // exit early if we found an edge
      return false;
    }

    MyNode<T> source = (MyNode<T>)addNodeFor(from);
    MyNode<T> target = (MyNode<T>)addNodeFor(to);

    // target cannot be head anymore and source cannot be tail
    heads.remove(target);
    tails.remove(source);

    if (source == target) {
      // reflexive
      source.addPred(source);
      source.addSucc(source);
    } else {
      source.addSucc(target);
      target.addPred(source);
    }

    return true;
  }

  @Override
  public boolean containsNodeFor(T item) {
    if (item == null)
      throw new NullPointerException();

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
    return nodes.values()
             .stream()
             .mapToInt(Node::outDegree)
             .sum();
  }

  @Override
  public void removeNodeFor(T item) {
    if (item == null || !nodes.containsKey(item))
      throw new NullPointerException();

    MyNode<T> node = (MyNode<T>)nodes.get(item);
    node.disconnect();

    if (node.isHead())
      heads.remove(node);

    if (node.isTail())
      tails.remove(node);

    nodes.remove(item);
  }

  @Override
  public boolean containsEdgeFor(T from, T to) {
    if (from == null || to == null) {
      throw new NullPointerException();
    }

    Node<T> source = nodes.get(from);
    Node<T> target = nodes.get(to);

    if (source == null || target == null)
      return false; // one of the nodes not found, then no connection

    return source.hasSucc(target) && target.hasPred(source);
  }

  @Override
  public boolean removeEdgeFor(T from, T to) {
    if (!containsEdgeFor(from, to)) {
      return false;
    }

    MyNode<T> source = (MyNode<T>)nodes.get(from);
    MyNode<T> target = (MyNode<T>)nodes.get(to);

    source.removeSucc(target);
    target.removePred(source);

    if (source.isTail()) {
      tails.add(source);
    }
    if (target.isHead()) {
      heads.add(target);
    }

    return true;
  }
}