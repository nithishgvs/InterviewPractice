package interview.functionalprogramming;

import java.util.List;
import java.util.function.Predicate;

public class MethodReferencesRunner {

  /**
   * Method reference makes code more readable
   *
   * @param number
   */
  public static void print(Integer number) {
    System.out.println(number);
  }

  public static boolean isEven(Integer num) {
    return num % 2 == 0;
  }


  public static void main(String[] args) {
    List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
        .map(s -> s.length()).forEach(v -> MethodReferencesRunner.print(v));

    List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
        .map(String::length).forEach(MethodReferencesRunner::print);

    /**
     * Storing functions in variables
     */
    Predicate<? super Integer> evenPredicate = getEvenPredicate();
    Predicate<? super Integer> oddPredicate = num -> num % 2 == 1;

    Integer max = List.of(23, 34, 44, 78, 43, 45).stream().filter(evenPredicate)
        .max((n1, n2) -> Integer.compare(n1, n2)).orElse(0);

    Integer max2 = List.of(23, 34, 44, 78, 43, 45).stream().filter(MethodReferencesRunner::isEven)
        .max(Integer::compare).orElse(0);
    System.out.println(max);
  }

  private static Predicate<Integer> getEvenPredicate() {
    return num -> num % 2 == 0;
  }

}
