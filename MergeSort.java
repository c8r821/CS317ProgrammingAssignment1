import java.util.Arrays;

class MergeSort implements SortMethod {
  // merge sort entry point
  public void sort(String[] list, int start, int end) {
    if (start < end) {
      int middle = (start + end) / 2;
        
      sort(list, start, middle);
      sort(list, middle + 1, end);

      merge(list, start, middle, end);
    }
  }

  public void merge(String[] list, int start, int middle, int end) {
    String[] left = new String[middle - start + 1];
    String[] right = new String[end - middle];

    if (left.length >= 0) System.arraycopy(list, start, left, 0, left.length);
    if (right.length >= 0) System.arraycopy(list, middle + 1, right, 0, right.length);

    int x = 0, y = 0, z = start;

    while (x < left.length && y < right.length) {
      if (left[x].compareToIgnoreCase(right[y]) <= 0)
        list[z++] = left[x++];
      else
        list[z++] = right[y++];
    }

    while (x < left.length)
      list[z++] = left[x++];

    while (y < right.length)
      list[z++] = right[y++];
  }
}