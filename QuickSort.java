class QuickSort implements SortMethod {
  // helper method to swap two elements in a list
  public void swap(String[] list, int a, int b) {
    String tmp = list[a];
    list[a] = list[b];
    list[b] = tmp;
  }

  // Actual quick sort entry point
  public void sort(String[] list, int start, int end) {
    if (start < end) {
      int p = partition(list, start, end);

      sort(list, start, p - 1);
      sort(list, p + 1, end);
    }
  }

  // quick sort partition
  public int partition(String[] list, int start, int end) {
    String pivot = list[start]; // Use first value as pivot

    int i = start + 1, j = end;

    while (i < j) {
      // moving i through array
      while (list[i].compareToIgnoreCase(pivot) < 0)
        i++;

      // moving j through array
      while (list[j].compareToIgnoreCase(pivot) > 0)
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

    return j;
  }
}