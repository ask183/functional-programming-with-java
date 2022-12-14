package functionalprogrammingwithstreamsinterfaceslambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterface {
    ////
    ///
    //Functional Interface is something which only has one abstract method
    //Lambda expression is something like an object because Objects are what are first-class citizens in Java.
    //In JavaScript, Python treats functions as first-class citizens. Just like you store data into variables, just like you pass data to a method, you can pass functions to a method, you can store a function into a variable in Python.
    ///
    ////


    /*
    boolean isEven(int x){
        return x%2==0;
    }

    int squared(int x){
        return x * x;
    }
     */

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(12,9,13,4,6,2,4,12,15);

        //////
        ////
        ////
        /////
        //Predicate Interface
        //Represents a predicate (boolean-valued function) of one argument.
        Predicate<Integer> isEvenPredicate = (Integer x) -> x % 2 == 0;
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>(){

            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        //////
        ////
        ////
        /////
        //Function Interface
        //Represents a function that accepts one argument and produces a result.
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>(){

            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };


        //////
        ////
        ////
        /////
        //Consumer Interface
        //Represents an operation that accepts a single input argument and returns no result/output(print to console, or store in database). Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
        Consumer<Integer> sysoutConsumer = System.out::println;
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream()
                .filter(isEvenPredicate) //lambda
                .map(squareFunction)  //lambda
                .forEach(sysoutConsumer);  //static method reference

        //////
        ////
        ////
        /////
        //BinaryOperator
        //Applies this function to the given arguments.(two inputs and get a output, inputs and output are of same type)
        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>(){

            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        int sum = numbers.stream()
                .reduce(0, sumBinaryOperator);



        //////
        ////
        ////
        /////
        //Supplier
        //No input -> return something
        System.out.println("-----No Input-------");
        Supplier <Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        //System.out.println(randomIntegerSupplier.get());

        //////
        ////
        ////
        /////
        //UnaryOperator Interface
        //Represents an operation on a single operand that produces a result of the same type as its operand.
        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println(unaryOperator.apply(10));

        //////
        ////
        ////
        /////
        //Bipredicate Interface
        //Bipredicate accepts two inputs
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number<10 && str.length()>5;
        };
        System.out.println(biPredicate.test(5, "helloworld"));


        //////
        ////
        ////
        /////
        //BiFunction Interface
        //BiFunction accepts two inputs
        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + " " + str;
        };
        System.out.println(biFunction.apply(5, "helloworld"));

        //////
        ////
        ////
        /////
        //BiConsumer Interface
        //BiConsumer takes two inputs and consumes it (does not return anything back)
        BiConsumer<Integer, String> biConsumer = (s1,s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept(25, "helloworld");


        //////
        ////
        ////
        /////
        //Operations Using Primitives when we are using Lambda expressions with Primitives

        //IntBinaryOperator
        IntBinaryOperator intBinaryOperator = (x,y) -> x + y;

        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator

    }
}
