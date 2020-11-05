class QuickSort implements SortMethod {
  // helper method to swap two elements in a list
  public void swap(String[] list, int a, int b) {
    String tmp = list[a];
    list[a] = list[b];
    list[b] = tmp;
  }

  // Actual quick sort entry point
  public void sort(String[] list, int start, int end) {
    // ensure we still have data to sort
    if (start < end) {
      // retrieve our partition index
      int p = partition(list, start, end);

      // sort the left side
      sort(list, start, p - 1);
      // sort the right side
      sort(list, p + 1, end);
    }
  }

  // quick sort partition
  public int partition(String[] list, int start, int end) {
    String pivot = list[start]; // Use first value as pivot

    // partition iterators
    int i = start + 1, j = end;

    // book implementation of partition
    while (i < j) {
      // moving i through array
      while (i <= end && list[i].compareToIgnoreCase(pivot) < 0)
        i++;

      // moving j through array
      while (j > start && list[j].compareToIgnoreCase(pivot) > 0)
        j--;

      // swap values at i and j
      if (i <= j) {
        swap(list, i, j);

        // keep moving i and j
        i++;
        j--;
      }
    }

    swap(list, start, j); // swap the pivot with j

    // return new index of pivot
    return j;
  }
}