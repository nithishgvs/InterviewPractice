package interview.functionalprogramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EvenNumberPredicate implements Predicate<Integer> {

  @Override
  public boolean test(Integer integer) {
    return integer % 2 == 0;
  }
}

class SystemOutConsumer implements Consumer<Integer> {

  @Override
  public void accept(Integer integer) {
    System.out.println(integer);
  }
}

class NumberSquareMapper implements Function<Integer, Integer> {

  @Override
  public Integer apply(Integer integer) {
    return integer * integer;
  }
}


public class LambdaBehindTheScreen {

  public static void main(String[] args) {
    /**
     * Stream<T> filter(Predicate<? super T> predicate);
     * boolean test(T t);
     * Predicate evaluates and returns if it's true/false
     */
    /**
     * forEach(Consumer<? super T> action);
     * void accept(T t);
     * void method take the element and do something
     */
    List.of(23, 34, 44, 78, 43, 45).stream().filter(new EvenNumberPredicate())
        .forEach(new SystemOutConsumer());

    /**
     * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
     * R apply(T t);
     * Functional interface returns another object value as output (R) and takes object T as input
     */
    List.of(23, 34, 44, 78, 43, 45).stream().filter(num -> num % 2 == 0).map(v -> v * v)
        .forEach(v -> System.out.println(v));

    List.of(23, 34, 44, 78, 43, 45).stream().filter(num -> num % 2 == 0)
        .map(new NumberSquareMapper())
        .forEach(v -> System.out.println(v));


  }
}
