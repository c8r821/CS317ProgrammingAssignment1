import java.time.Duration;
import java.time.Instant;

class Main {
  public static void run(SortMethod method) {
    FileReader file = new FileReader();

    file.prompt();

    int length = file.parse();
    String[] list = file.getContents();

    Instant start = Instant.now();
    method.sort(list, 0, length - 1);
    Duration sortTime = Duration.between(start, Instant.now());

    System.out.printf("It took %f milliseconds to %s the data\n\n", sortTime.toNanos() / 1000000.0, method.getClass().getName());

    System.out.println("Contents are as follows:");
    System.out.println("------------------------");

    for (int i = 0; i < length; i++) {
      System.out.println(list[i]);
    }
  }

  public static void main(String[] args) {
    run(new QuickSort());
    run(new MergeSort());
  }
}