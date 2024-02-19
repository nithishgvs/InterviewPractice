package interview.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class GenericRunner {

    //Here <X> is the type we are defining this method returns the same type
    static <X> X doubleValue(X value) {
        return value;
    }

    static <X extends List> void duplicateList(X list) {
        list.addAll(list);
    }

    //? is wild card any object extending Number class can be used, extends is upper bound wildcard

    /**
     *
     * In Java generics, an upper bound wildcard (<? extends T>) allows you to specify that a generic type can be any type that is a subtype of a particular type T or T itself. This means that you can use any type that is a subclass of T, including T itself
     */
    static Number sumOfNumbers(List<? extends Number> numbers) {
        /**
         *  double sum = 0.0;
         *         for (Number val : numbers) {
         *             sum += val.doubleValue();
         *         }
         *         return sum;
         */
        return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    //Lower bound wild card uses super keyword

    /**
     *
     * In Java generics, a lower bound wildcard (<? super T>) allows you to specify that a generic type can be any type that is a supertype of a particular type T or T itself. This means that you can use any type that is a superclass of T, including T itself.
     */
    static void addNumber(List<? super Number> numbers) {
        numbers.add(1);
        numbers.add(1.2);
        numbers.add(300l);
    }

    public static void main(String[] args) {
        Integer integer = doubleValue(1);
        System.out.println(integer);
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> result = doubleValue(list);
        System.out.println(result);
        duplicateList(list);
        System.out.println(list);
        //Integer
        System.out.println(sumOfNumbers(List.of(1, 2, 3, 4)));
        //Long
        System.out.println(sumOfNumbers(List.of(1l, 2l, 3l, 4l)));
        //float
        System.out.println(sumOfNumbers(List.of(1.1, 2.9, 3, 4)));

    }
}
