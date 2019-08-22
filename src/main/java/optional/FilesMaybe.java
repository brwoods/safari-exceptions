package optional;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class FilesMaybe {
  public static List<String> getLines(String filename) {
    try {
      return Files.readAllLines(Paths.get(filename));
    } catch (IOException fnfe){
      return null;
    }
  }

  public static void main(String[] args) {
    String filename = "missing.txt";
    Optional.of(filename)
        .map(s -> getLines(s))
        .ifPresent(l -> System.out.println("File contains " + l));
  }
}
