package interview.functionalprogramming;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FPNumberRunner {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 6, 8, 13, 3, 15);
        //0 is starting value
        int sum = numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("Sum: " + sum);

        int oddSum = numbers.stream().filter(n -> n % 2 != 0).reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("OddSum: " + oddSum);

        /**
         * filter,sort are intermediate operations which result in another stream
         *
         * reduce,foreach are terminal operation which result in single element
         */


        //sorted is intermediate operation which returns another stream

        List<Integer> numbers2 = List.of(4, 6, 8, 13, 3, 15, 13, 4);
        numbers2.stream().distinct().sorted().forEach(number -> System.out.println(number));
        System.out.println("-----------------------------------------");
        numbers2.stream().distinct().sorted().map(e -> e * e).forEach(number -> System.out.println(number));
        System.out.println("-----------------------------------------");
        System.out.println(IntStream.range(1, 11).reduce(0, (num1, num2) -> num1 + num2));
        System.out.println("-----------------------------------------");
        System.out.println(List.of(4, 6, 8, 13, 3, 15, 13, 4).stream().max(Integer::compare).get());
        System.out.println("-----------------------------------------");
        System.out.println(List.of(4, 6, 8, 13, 3, 15, 13, 4).stream().min(Integer::compare).get());
        System.out.println("-----------------------------------------");
        System.out.println(List.of(4, 6, 8, 13, 3, 15, 13, 4).stream().filter(e -> e % 2 != 0).collect(Collectors.toList()));

        System.out.println("-----------------------------------------");
        System.out.println(IntStream.range(1, 11).map(n -> n * n).boxed().collect(Collectors.toList()));
        System.out.println("-----------------------------------------");
        System.out.println(List.of(1, 2, 3, 4, 5).stream().filter(n -> n > 6).max(Integer::compare).orElse(-1));

    }
}
