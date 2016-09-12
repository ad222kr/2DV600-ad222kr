package ad222kr_assign2.e_1;

/**
 * Created by alex on 2016-09-12.
 */
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
    if (!checkIndex(index, size)) {
      throw new IndexOutOfBoundsException();
    }
    if (size == values.length) {
      resize();
    }
    values[index] = n;
    size++;
  }

  @Override
  public void remove(int index) throws IndexOutOfBoundsException {
    if (!checkIndex(index, size)) {
      throw new IndexOutOfBoundsException();
    }

    int[] temp = new int[values.length];
    // Copy first half, ignore elem at index and copy rest
    System.arraycopy(values, 0, temp, 0, index);
    System.arraycopy(values, index + 1, temp, index, values.length - index - 1);
    values = temp;
    size--;
  }

  @Override
  public int get(int index) throws IndexOutOfBoundsException {
    if (!checkIndex(index, size)) {
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
    return -1;
  }

}
