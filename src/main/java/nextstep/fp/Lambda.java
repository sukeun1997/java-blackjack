package nextstep.fp;

import java.util.List;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream().mapToInt(n->n).sum();
    }

    public static int sumAllEven(List<Integer> numbers, Sum sum) {
        return numbers.stream().filter(n -> sum.isNum(n,2)).mapToInt(a->a).sum();
    }

    public static int sumAllOverThree(List<Integer> numbers, Sum sum) {
        return numbers.stream().filter(n -> sum.isNum(n,3)).mapToInt(a->a).sum();
    }
}
