package functionalprogrammingwithstreamsinterfaceslambdas;

import java.util.Arrays;
import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15, 123, 14);
       // printAllNumbersInListFunctional(numbers);
       // printEvenNumbersInListFunctional(numbers);
       // printOddNumbersInListFunctional(numbers);
        //printSquaresOfEvenNumbersInListFunctional(numbers);
       // printCubesOfOddNumbersInListFunctional(numbers);

        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        //printAllCoursesInListFunctional(courses);
       // printAllCoursesWith4Letters(courses);
        printNumberOfCharactersInACourse(courses);
    }

//    private static void print(int number) {
//        System.out.println(number);
//    }

//    private static boolean isEven(int number) {
//        return number%2 == 0;
//    }


    private static void printAllNumbersInListFunctional(List<Integer> numbers){
        //What to do?
        numbers.stream()
                .forEach(System.out::println);    //method reference
    }

    //lambda syntax
    //number -> number%2 == 0
    private static void printEvenNumbersInListFunctional(List<Integer> numbers){
        //what to do? (functional programming)

        numbers.stream()
               // .filter(FP01Functional::isEven) //method reference for the method to be called on each of the numbers//Filter - Only Allow Even Numbers
                .filter(number -> number%2 == 0) //lambda expression (method)
                .forEach(System.out::println);  //method reference
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number%2 != 0)
                .forEach(System.out::println);
    }

    private static void printAllCoursesInListFunctional(List<String> courses){
        courses.stream()
                .filter(FP01Functional::isContainingSpring)
                .forEach(System.out::println);
    }

    private static boolean isContainingSpring(String course){
        if (course.contains("Spring")){
            System.out.println(course);
        }
        return false;
    }

    private static void printAllCoursesWith4Letters(List<String> courses){
        courses.stream()
                .filter(FP01Functional:: isContainingAtleast4Letters)
                .forEach(System.out::println);
    }

    private static boolean isContainingAtleast4Letters(String course){
        if (course.length() >= 4){
            System.out.println(course);
        }
        return false;
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers){
        numbers.stream()//convert to stream
                .filter(number -> number%2 == 0)//lambda expression
                //mapping - x -> x * x
                .map(number -> number * number)
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number%2 != 0) //filter specifies condition only if that condition is matched then the element would go further otherwise the element is filtered out
                .map(number -> number * number * number) //map one value to another value
                .forEach(System.out::println);  //forEach is used to consume an element
    }

    private static  void printNumberOfCharactersInACourse(List<String> courses){
        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }
}


