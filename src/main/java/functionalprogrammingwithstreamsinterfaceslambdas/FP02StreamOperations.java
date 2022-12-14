package functionalprogrammingwithstreamsinterfaceslambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP02StreamOperations {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);

        numbers.stream()
                .distinct() //  returns Stream<T> Intermediate Operation
                .sorted() //returns Stream<T> Intermediate Operation
                .forEach(System.out::println); //returns void Terminal Operation

        List<Integer> squaredNumbers = numbers.stream()
                .map(number -> number * number) //returns Stream<R> Intermediate Operation (maps operation on each value of stream and returns stream with new value)
                .collect(Collectors.toList()); //returns R Terminal Operation

        List<Integer> evenNumbersOnly = numbers.stream()
                .filter(x -> x%2 == 0) //returns Stream<T> Intermediate Operation
                .collect(Collectors.toList());

        int sum = numbers.stream()
                .reduce(0, (x,y) -> x*x + y*y); //returns T Terminal Operation
    }
}
