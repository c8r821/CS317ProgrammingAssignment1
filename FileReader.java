import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileReader {
  private static final int MAX_LINE_COUNT = 200000;

  private String filename;
  private File file;
  private Scanner scanner;

  private String[] contents = new String[MAX_LINE_COUNT];

  public void prompt() {
    while (true) {
      System.out.print("Enter the path to your imput file: ");
      filename = new Scanner(System.in).nextLine();

      try {
        file = new File(filename);
        scanner = new Scanner(file);
        break;
      } catch (FileNotFoundException error) {
        System.out.println("The specified file could not be found. Please check the path entered and try again!\n");
      }
    }
  }

  public int parse() {
    int i = 0;

    while (scanner.hasNextLine()) {
      contents[i++] = scanner.nextLine();
    }

    return i;
  }

  public String[] getContents() {
    return contents;
  }
}