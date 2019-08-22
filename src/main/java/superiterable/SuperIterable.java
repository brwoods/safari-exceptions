package superiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

// "Functor" wrapper around stuff that allows applying a function to that stuff
// and creates a new wrapper (of the same type?) around the results
public class SuperIterable<T> implements Iterable<T> {
  private Iterable<T> self;

  public SuperIterable(Iterable<T> target) {
    self = target;
  }
//  public <B> SuperIterable<B> map(Function<T, B> op) {
  public <B> SuperIterable<B> map(Function<T, B> op) {
    List<B> out = new ArrayList<>();
    for (T s : self) {
      B b = op.apply(s);
      if (b != null) { // Mathematician says "not a proper functor!!"
        out.add(b);
      }
    }
    return new SuperIterable<>(out);
  }

//  public void forEvery(Consumer<T> op) {
//    for (T t : self) op.accept(t);
//  }

  public void ifEmpty(Runnable r) {
    if (self.iterator().hasNext() == false) {
      r.run();
    }
  }
  public Iterator<T> iterator() {
    return self.iterator();
  }
}
