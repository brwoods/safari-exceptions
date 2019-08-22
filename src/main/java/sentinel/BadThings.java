package sentinel;

import java.io.FileReader;

public class BadThings {
  public static void main(String[] args) throws Throwable {
    FileReader fileReader = new FileReader("text.txt");
    int c;
    while (true) {
      c = fileReader.read();
      System.out.print((char)c);
    }
  }
}
