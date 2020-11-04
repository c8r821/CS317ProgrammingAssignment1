import java.time.Duration;
import java.time.Instant;

class Main {
  private static FileHandler file = new FileHandler();

  public static void run(SortMethod method) {
    int length = file.parse();
    String[] list = file.getContents();

    Instant start = Instant.now();
    method.sort(list, 0, length - 1);
    Duration sortTime = Duration.between(start, Instant.now());

    System.out.printf("It took %f milliseconds to %s the data\n\n", sortTime.toNanos() / 1000000.0, method.getClass().getName());

    file.printToFile(method.getClass().getName());
  }

  public static void main(String[] args) {
    file.prompt();

    run(new QuickSort());
    run(new MergeSort());
  }
}