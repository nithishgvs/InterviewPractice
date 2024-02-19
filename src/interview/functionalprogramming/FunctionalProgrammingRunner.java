package interview.functionalprogramming;

import java.util.List;

public class FunctionalProgrammingRunner {
    public static void main(String[] args) {

        List<String> list = List.of("Apple", "Banana", "Cat", "Dog");
        printListFp(list);
    }

    public static void printListFp(List<String> list) {
        //void forEach(Consumer<? super T> action);
        list.stream().forEach(element -> System.out.println(element));
    }
}
