package functionalprogrammingwithstreamsinterfaceslambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

    private static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {

        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
              //  .map(str -> str.toUpperCase())
                .map(String::toUpperCase)   //method reference on the object (member method, normal method)
                .forEach(FP03MethodReferences::print);  //static method  reference

        /////
        ///
        /////
        //constructor reference
//        Supplier<String> supplier = () -> new String();
        Supplier<String> supplier = String::new;

    }
}
