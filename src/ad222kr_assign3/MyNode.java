package ad222kr_assign3;

import graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Class representing a node in a Graph
 */
public class MyNode<T> extends Node<T> {
  /**
   * HashSet holding the predecessors of this node
   * A is a predecessor of B if A ----> B
   */
  private Set<Node<T>> predecessors;

  /**
   * HashSet holding the successors of this node
   * B is a successor of A if A -----> B
   */
  private Set<Node<T>> successors;

  /**
   * Constructs a new node using <tt>item</tt> as key.
   *
   * @param item
   */
  protected MyNode(T item) {
    super(item);
    predecessors = new HashSet<>();
    successors = new HashSet<>();
  }


  @Override
  public boolean hasSucc(Node<T> node) {
    return successors.contains(node);
  }

  @Override
  public int outDegree() {
    return successors.size();
  }

  @Override
  public Iterator<Node<T>> succsOf() {
    return successors.iterator();
  }

  @Override
  public boolean hasPred(Node<T> node) {
    return predecessors.contains(node);
  }

  @Override
  public int inDegree() {
    return predecessors.size();
  }

  @Override
  public Iterator<Node<T>> predsOf() {
    return predecessors.iterator();
  }

  @Override
  protected void addSucc(Node<T> succ) {
    if (succ == null) {
      throw new NullPointerException();
    }
    successors.add(succ);
  }

  @Override
  protected void removeSucc(Node<T> succ) {
    if (succ == null)
      throw new NullPointerException();
    successors.remove(succ);
  }

  @Override
  protected void addPred(Node<T> pred) {
    if (pred == null) {
      throw new NullPointerException();
    }

    predecessors.add(pred);
  }

  @Override
  protected void removePred(Node<T> pred) {
    if (pred == null)
      throw new NullPointerException();
    predecessors.remove(pred);
  }

  @Override
  protected void disconnect() {
    for (Node<T> pred : predecessors) {
      ((MyNode<T>)pred).removeSucc(this);
    }
    for (Node<T> succ : successors) {
      ((MyNode<T>)succ).removePred(this);
    }

    predecessors.clear();
    successors.clear();
  }

  /**
   * @return the hashcode value for the given instance
   */
  @Override
  public int hashCode() {
    return Objects.hash(item());
  }

  /**
   * @param obj to compare against
   * @return true if the nodes hold the same items and has the same hashcodes
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof MyNode) {
      return item() == ((MyNode) obj).item() &&
             hashCode() == obj.hashCode();
    }

    return false;
  }
}
