package ad222kr_assign3;

import org.junit.Test;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;


/**
 * Created by alex on 2016-09-30.
 */
public class NodeUnitTest {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  /**
   * MyNode::addSucc()
   */
  @Test
  public void addSucc_validNode() {
    MyNode<Integer> node = new MyNode<>(1);
    MyNode<Integer> succ = new MyNode<>(2);

    node.addSucc(succ);

    int expectedOutDegree = 1;
    int actualOutDegree = node.outDegree();

    assertEquals("outDegree of node should be 1",
      expectedOutDegree, actualOutDegree);
  }

  @Test
  public void addSucc_10000Elements() {
    MyNode<Integer> node = new MyNode<>(1);
    int expectedOutDegree = 10000;
    for (int i = 1; i <= expectedOutDegree; i++) {
      node.addSucc(new MyNode<>(i));
    }
    int actualOutDegree = node.outDegree();

    assertEquals(expectedOutDegree, actualOutDegree);
  }

  @Test
  public void addSucc_reflexive() {
    MyNode<Integer> node = new MyNode<>(1);
    node.addSucc(node);

    int expectedOutDegree = 1;
    int actualOutDegree = node.outDegree();

    assertEquals("Should be able to add a reflexive edge",
      expectedOutDegree, actualOutDegree);
    assertTrue(node.hasReflexiveEdges());
  }

  @Test
  public void addSucc_reflexiveDifferentInstanceSameValue() {
    MyNode<Integer> node = new MyNode<>(42);
    MyNode<Integer> other = new MyNode<>(42);

    node.addSucc(other);

    int expectedOutDegree = 1;
    int actualOutDegree = node.outDegree();

    assertEquals("Should add a reflexive edge even if the node instances are different but with same value",
      expectedOutDegree, actualOutDegree);

    assertTrue("The node should ha a reflexive edge", node.hasReflexiveEdges());
  }


  @Test
  public void addSucc_null() {
    exception.expect(NullPointerException.class);

    MyNode<Integer> node = new MyNode<>(42);

    node.addSucc(null);
  }

  /**
   * MyNode::addPred()
   */
  @Test
  public void addPred_validNode() {
    MyNode<Integer> node = new MyNode<>(1);
    MyNode<Integer> succ = new MyNode<>(2);

    node.addPred(succ);

    int expectedInDegree = 1;
    int actualInDegree = node.inDegree();

    assertEquals("inDegree of node should be 1",
      expectedInDegree, actualInDegree);
  }

  @Test
  public void addPred_reflexive() {
    MyNode<Integer> node = new MyNode<>(1);
    node.addPred(node);

    int expectedInDegree = 1;
    int actualInDegree = node.inDegree();

    assertEquals("Should be able to add the same node reference as a predecessor",
      expectedInDegree, actualInDegree);
  }

  @Test
  public void addPred_reflexiveDifferentInstanceSameValue() {
    MyNode<Integer> node = new MyNode<>(42);
    MyNode<Integer> other = new MyNode<>(42);

    node.addPred(other);

    int expectedInDegree = 1;
    int actualInDegree = node.inDegree();

    assertEquals("Should be able to add the same node but diffrent instance as a pred",
      expectedInDegree, actualInDegree);
  }

  @Test
  public void addPred_null() {
    exception.expect(NullPointerException.class);

    MyNode<Integer> node = new MyNode<>(42);

    node.addPred(null);
  }

}
