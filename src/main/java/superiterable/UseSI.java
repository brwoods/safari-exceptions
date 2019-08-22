package superiterable;

import java.util.*;

public class UseSI {
  // functional style "higher order" function
  // OO design patterns call this "Command"
//  public static <A, B> List<B> map(Iterable<A> in, Function<A, B> op) {
//    List<B> out = new ArrayList<>();
//    for (A s : in) {
//      out.add(op.apply(s));
//    }
//    return out;
//  }
//  public static List<Integer> lengthAll(List<String> in) {
//    List<Integer> out = new ArrayList<>();
//    for (String s : in) {
//      out.add(s.length());
//    }
//    return out;
//  }
  public static void main(String[] args) {
    SuperIterable<String> ls = new SuperIterable<>(Arrays.asList("Fred", "Jim", "Sheila"));

//    System.out.println(ls.map(s -> s.toUpperCase()));
//    System.out.println(ls.map(s -> s.toLowerCase()));
////    System.out.println(lengthAll(ls));
//    System.out.println(ls.map(s -> s.length()));
//
//    for (String s : ls) {
//      System.out.println("> " + s);
//    }
    ls
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));
    ls
        .map(s -> s.toLowerCase())
        .forEach(s -> System.out.println(s));
    ls
        .map(s -> s.length())
        .forEach(s -> System.out.println(s));

    System.out.println("-------- empty SuperIterable here -------");
    SuperIterable<String> empty = new SuperIterable<>(Arrays.asList());
    empty
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));
    System.out.println("-----------------------------------------");

    Map<String, String> names = new HashMap<>();
    names.put("Fred", "Jones");
    //...
    String first = "Fred";
//    String last = names.get(first);
//    String message = "Dear " + last.toUpperCase();
//    System.out.println(message);

    SuperIterable<Map<String, String>> simss =
        new SuperIterable<>(Arrays.asList(names));
    SuperIterable<String> message = simss
        .map(m -> m.get(first))
        .map(s -> s.toUpperCase())
        .map(s -> "Dear " + s);
    message.forEach(s -> System.out.println(s));
    message.ifEmpty(() -> System.out.println("No name found"));

    Optional<Map<String, String>>  omss = Optional.of(names);
    Optional<String> msg2 = omss
        .map(m -> m.get(first))
        .map(s -> s.toUpperCase())
        .map(s -> "Dear " + s);
    msg2.ifPresent(s -> System.out.println("From Optional: " + s));
//    this block is equivalent to the orElse statement that follows...
//    String msg3;
//    if (msg2.isPresent()) {
//      msg3 = msg2.get(); // throws NoSuchElementException if empty!!!
//    } else {
//      msg3 = "No name found";
//    }
    String msg3 = msg2.orElse("No name found");
    System.out.println("orelse gives: " + msg3);
  }
}
