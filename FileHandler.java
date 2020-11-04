import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileHandler {
  private static final int MAX_LINE_COUNT = 200000;

  private int length;

  private String filename;
  private File file;

  private String[] contents = new String[MAX_LINE_COUNT];

  public void prompt() {
    System.out.print("Enter the path to your imput file: ");
    Scanner promptScanner = new Scanner(System.in);
    filename = promptScanner.nextLine();
    promptScanner.close();

    file = new File(filename);
  }

  public int parse() {
    length = 0;

    try (Scanner input = new Scanner(file)) {
      while (input.hasNextLine()) {
        contents[length++] = input.nextLine();
      }  
    } catch (FileNotFoundException e) {
      System.out.println("The specified file could not be found. Please check the path entered and try again!\n");
      System.exit(1);
    }
    
    return length;
  }

  public String[] getContents() {
    return contents;
  }

  public void printToFile(String sortMethod) {
    int extIndex = filename.lastIndexOf('.');
    String filenameNoExt = filename.substring(0, extIndex);
    String ext = filename.substring(extIndex);

    String outname = filenameNoExt + "." + sortMethod + ext;

    try (FileWriter output = new FileWriter(outname)) {
      for (int i = 0; i < length; i++)
        output.write(contents[i] + '\n');

      output.close();
    } catch (IOException e) {
      System.out.println("Output file could not be opened please check folder permissions and try again.\n");
      System.exit(1);
    }
  }
}