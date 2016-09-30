package ad222kr_assign3;

import graphs.Node;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Created by alex on 30.9.16.
 */
public class MyNode<T> extends Node<T> {
  private Set<Node<T>> predesessors;
  private Set<Node<T>> successors;

  /**
   * Constructs a new node using <tt>item</tt> as key.
   *
   * @param item
   */
  protected MyNode(T item) {
    super(item);
    predesessors = new HashSet<>();
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
    return predesessors.contains(node);
  }

  @Override
  public int inDegree() {
    return predesessors.size();
  }

  @Override
  public Iterator<Node<T>> predsOf() {
    return predesessors.iterator();
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
    successors.remove(succ);
  }

  @Override
  protected void addPred(Node<T> pred) {
    if (pred == null) {
      throw new NullPointerException();
    }
    if (this.equals(pred)) {
      // hasReflexiveEdges only checks hasSucc, but removeReflexiveEdges
      // returns both succ and pred.. SOO my assumption here is.. if you try
      // to add a pred that is the same node, just ad it to successors and silently
      // return
      // TODO: check at handledning
      successors.add(pred);
      return;
    }

    predesessors.add(pred);
  }

  @Override
  protected void removePred(Node<T> pred) {
    predesessors.remove(pred);
  }

  @Override
  protected void disconnect() {
    predesessors.clear();
    successors.clear();
  }

  @Override
  public int hashCode() {
    return Objects.hash(item());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof MyNode) {
      return item() == ((MyNode) obj).item() &&
             hashCode() == obj.hashCode();
    }

    return false;
  }
}
