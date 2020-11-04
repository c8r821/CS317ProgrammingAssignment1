class QuickSort implements SortMethod {
  public void sort(String[] list, int start, int end) {
    if (start < end) {
      int p = partition(list, start, end);

      sort(list, start, p - 1);
      sort(list, p + 1, end);
    }
  }

  public int partition(String[] list, int start, int end) {
    String pivot = list[end];
    int i = start - 1;
    for (int x = start; x < end; x++) {
      if (list[x].compareToIgnoreCase(pivot) < 0) {
        i++;

        String temp = list[i];
        list[i] = list[x];
        list[x] = temp;
      }
    }

    String temp = list[i + 1];
    list[i + 1] = list[end];
    list[end] = temp;

    return i + 1;
  }
}