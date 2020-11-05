import java.time.Duration;
import java.time.Instant;

class Main {
  // static instance of helper class to prompt and parse file
  private static final FileHandler file = new FileHandler();

  // reusable function that gets data from file, sorts it, and outputs metrics
  public static void run(SortMethod method) {
    int length = file.parse();
    String[] list = file.getContents();

    // track when sorting started
    Instant start = Instant.now();
    // perform actual sort
    method.sort(list, 0, length - 1);
    // record duration spent sorting
    Duration sortTime = Duration.between(start, Instant.now());
    System.out.printf("It took %f milliseconds to %s the data\n", sortTime.toNanos() / 1000000.0, method.getClass().getName());

    // output data to file
    file.printToFile(method.getClass().getName());

    System.out.println();
  }

  public static void main(String[] args) {
    // prompt for file name
    file.prompt();

    run(new QuickSort());
    run(new MergeSort());
  }
}