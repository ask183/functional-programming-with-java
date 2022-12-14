package functionalprogrammingwithstreamsinterfaceslambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class F03BehaviorParameterization {

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(12,9,13,4,6,2,4,12,15);

//        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
//        numbers.stream()
//                .filter(evenPredicate)
//                .forEach(System.out::println);
//
//        System.out.println("-----");
//
//        Predicate<Integer> oddPredicate = x -> x % 2 != 0;
//        filterAndPrint(numbers, x-> x%3==0);
//        System.out.println("-----");
//        filterAndPrint(numbers, x-> x%2==0);
//        System.out.println("-----");
//        filterAndPrint(numbers, x-> x%2!=0);

        //behavioral parameterization example

        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);
        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x -> x + x);
        List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);
        System.out.println(doubledNumbers);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
