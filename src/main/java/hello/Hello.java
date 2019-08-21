package hello;

public class Hello {
  public static void main(String[] args) {
    ((Runnable)() -> System.out.println("Hello Exceptions World!")).run();
  }
}
