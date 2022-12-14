package functionalprogrammingwithstreamsinterfaceslambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15,1);

        List<Integer> squaredNumbers = squaredList(numbers);
        //System.out.println(squaredNumbers);

        List<Integer> evenNumbersOnly = numbers.stream()
                                            .filter(x -> x%2 ==0)
                                            .collect(Collectors.toList());
        System.out.println(evenNumbersOnly);

        int sum = addListFunctional(numbers);
        System.out.println(sum);
    }

    private static List<Integer> squaredList(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x*x)
                .collect(Collectors.toList());
    }

    private static int sum(int a, int b){
        System.out.println(a + " " + b);
        return a + b;
    }

    private static int addListFunctional(List<Integer> numbers) {
        //stream of number -> one result value
        //combine them into one result => one value
        //initial value of 0 and FP02Functional::sum
        return numbers.stream()
                .parallel()
             //   .reduce(0, FP02Functional::sum); //reduce operation helps us to take list of numbers and reduce it to single value
             //   .reduce(0, (x,y) -> x +y);
                //12, 9, 13, 4, 6, 2, 4, 12, 15,1
                .reduce(0, Integer::sum);
    }



}
