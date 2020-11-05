class MergeSort implements SortMethod {
  // merge sort entry point
  public void sort(String[] list, int start, int end) {
    if (start < end) {
      int middle = (start + end) / 2;

      // recursively sort left half
      sort(list, start, middle);
      // recursively sort right half
      sort(list, middle + 1, end);

      // merge both halves
      merge(list, start, middle, end);
    }
  }

  public void merge(String[] list, int start, int middle, int end) {
    // temp array holding this left half
    String[] left = new String[middle - start + 1];
    // temp array holding the right half
    String[] right = new String[end - middle];

    // copy values from list into our temp left
    if (left.length >= 0) System.arraycopy(list, start, left, 0, left.length);
    // copy values from list into our temp right
    if (right.length >= 0) System.arraycopy(list, middle + 1, right, 0, right.length);

    // merge iterators
    int x = 0, y = 0, z = start;

    // while we have to compare our left and right interleave them
    while (x < left.length && y < right.length) {
      if (left[x].compareToIgnoreCase(right[y]) <= 0)
        list[z++] = left[x++];
      else
        list[z++] = right[y++];
    }

    // merge whatever is LEFT
    while (x < left.length)
      list[z++] = left[x++];

    // merge whatever is left on the right
    while (y < right.length)
      list[z++] = right[y++];
  }
}