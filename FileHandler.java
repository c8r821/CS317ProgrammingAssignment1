import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

// helper class to prompt for, parse, and return file contents
class FileHandler {
  // holds number of lines in file
  private int length;

  // filename given in prompt
  private String filename;

  // reference to the file
  private File file;

  // string contents of file
  private String[] contents;

  // prompt user for name of file
  public void prompt() {
    System.out.print("Enter the path to your input file: ");
    Scanner promptScanner = new Scanner(System.in);
    filename = promptScanner.nextLine();
    promptScanner.close();

    try {
      // count number of lines in file
      int lineCount = (int)Files.lines(Paths.get(filename)).count();
      contents = new String[lineCount];
    } catch (IOException e) {
      System.out.println("Could not read number of lines in file, please check permissions and try again.\n");
      System.exit(1);
    }

    file = new File(filename);
  }

  // read in contents of file to array
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

  // return contents of file to the user
  public String[] getContents() {
    return contents;
  }

  // output contents to appropriately named file
  public void printToFile(String sortMethod) {
    int extIndex = filename.lastIndexOf('.');
    String filenameNoExt = filename.substring(0, extIndex);
    String ext = filename.substring(extIndex);

    String outname = filenameNoExt + "." + sortMethod + ext;

    System.out.println("Sorted contents printed to: " + outname);

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