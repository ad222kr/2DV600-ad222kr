package ad222kr_assign2.e_1;

import da1031.AbstractIntCollection;
import da1031.IntStack;

public class ArrayIntStack  extends AbstractIntCollection implements IntStack {
  @Override
  public void push(int n) {
    values[size++] = n;
    if (values.length == size) {
      resize();
    }
  }

  @Override
  public int pop() throws IndexOutOfBoundsException {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Stack is empty");
    }

    int n = values[size - 1];
    values[size - 1] = 0;
    size--;

    return n;
  }

  @Override
  public int peek() throws IndexOutOfBoundsException {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Stack is empty");
    }
    return values[size - 1];
  }
}