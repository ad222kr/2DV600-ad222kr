package ad222kr_assign2.e_1;

import da1031.AbstractIntCollection;
import da1031.IntList;

public class ArrayIntList extends AbstractIntCollection implements IntList {
  @Override
  public void add(int n) {
    if (size == values.length) {
      resize();
    }
    values[size++] = n;
  }

  @Override
  public void addAt(int n, int index) throws IndexOutOfBoundsException {
    if (!checkIndex(index, size + 1)) {
      throw new IndexOutOfBoundsException();
    }
    if (size == values.length) {
      resize();
    }

    for (int i = size; i > index; i--) {
      values[i] = values[i - 1];
    }
    values[index] = n;
    size++;
  }

  @Override
  public void remove(int index) throws IndexOutOfBoundsException {
    if (isEmpty() || !checkIndex(index, size)) {
      throw new IndexOutOfBoundsException();
    }

    for (int i = index; i < size; i++) {
      values[i] = values[i + 1];
    }
    size--;
  }

  @Override
  public int get(int index) throws IndexOutOfBoundsException {
    if (isEmpty() || !checkIndex(index, size)) {
      throw new IndexOutOfBoundsException();
    }
    return values[index];
  }

  @Override
  public int indexOf(int n) {
    for(int i = 0; i < values.length; i++) {
      if (values[i] == n) {
        return i;
      }
    }
    return -1; // if we did not find the element, this seems to be the standard way to go
  }
}