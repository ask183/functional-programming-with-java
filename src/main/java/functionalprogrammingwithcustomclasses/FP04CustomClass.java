package functionalprogrammingwithcustomclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numOfStudents;

    public Course(String name, String category, int reviewScore, int numOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numOfStudents = numOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public String toString() {
        return name + ":" + numOfStudents + ":" + reviewScore;
    }
}

public class FP04CustomClass {

    public static void main(String[] args){
        List<Course> courses = Arrays.asList(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        //stream functions
        //allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;


//        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
//        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90Predicate));
//
//        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
//
//        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
////////---------------------------------------------------
        Predicate<Course> numberStudentsGreaterThan10000Predicate = course -> course.getNumOfStudents() > 10000;
        Predicate<Course> numberStudentsLessThan10000Predicate = course -> course.getNumOfStudents() < 10000;
        Predicate<Course> numberStudentsGreaterThan20000Predicate = course -> course.getNumOfStudents() > 20000;
//        System.out.println(courses.stream().allMatch(numberStudentsGreaterThan10000Predicate));
//        System.out.println(courses.stream().allMatch(numberStudentsLessThan10000Predicate));
//        System.out.println(courses.stream().noneMatch(numberStudentsLessThan10000Predicate));
//        System.out.println(courses.stream().noneMatch(numberStudentsGreaterThan20000Predicate));
//        System.out.println(courses.stream().anyMatch(numberStudentsGreaterThan20000Predicate));

        ////
        ///
        //
        //Sorting courses with sorted and creating Comparators
        //
        ///
        /////
//        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNumOfStudents);
//                System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));
//                //[FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

//        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::getNumOfStudents).reversed();
//                    System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));
                    //[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        Comparator<Course> comparingByNoOfStudentsAndNumOfReviews
                = Comparator.comparing(Course::getNumOfStudents)
                            .thenComparing(Course::getReviewScore)
                            .reversed();
//        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNumOfReviews).limit(5).collect(Collectors.toList()));
        // [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]
 //        //[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]


//        Comparator<Course> comparingByNoOfStudentsAndNumOfReviews
//                = Comparator.comparing(Course::getNumOfStudents)
//                            .thenComparing(Course::getReviewScore)
//                            .reversed();
//        System.out.println(
//                courses.stream()
//                        .sorted(comparingByNoOfStudentsAndNumOfReviews)
//                        .skip(3)
//                        .limit(5)
//                        .collect(Collectors.toList()));
        //[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95]

//        System.out.println(courses);
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

        //return all the courses until one of the courses doesn't have the condition (takeWhile())
//        System.out.println(
//            courses.stream()
//                    .takeWhile(course -> course.getReviewScore() >= 95)
//                    .collect(Collectors.toList()));
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]

        //drop the courses that doesn't have the condition (dropWhile())
//        System.out.println(
//            courses.stream()
//                    .dropWhile(course -> course.getReviewScore() >= 95)
//                    .collect(Collectors.toList()));
        //[FullStack:14000:91, AWS:21000:92, Docker:20000:92, Kubernetes:20000:91]

        ////max returns the last element of the list
        System.out.println(
                courses.stream()
                        .max(comparingByNoOfStudentsAndNumOfReviews)
        );
        //Optional[FullStack:14000:91]

        ////min returns the first element of the list
        System.out.println(
                courses.stream()
                        .min(comparingByNoOfStudentsAndNumOfReviews)
        );
        //Optional[Microservices:25000:96]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(comparingByNoOfStudentsAndNumOfReviews)
                        .orElse(new Course ("Kubernetes", "Cloud", 91, 20000))
        );
        //Optional.empty
        //optional provides you a way to check if a result exists or not

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findFirst()
        );//Optional[Spring:20000:98]


        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findAny()
        );//Optional[Spring:20000:98]


        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(course -> course.getNumOfStudents())
                        .sum()
        );//88000


        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(course -> course.getNumOfStudents())
                        .average()
        );//OptionalDouble[22000.0]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(course -> course.getNumOfStudents())
                        .count()
        ); //4 courses

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(course -> course.getNumOfStudents())
                        .max()
        );//OptionalInt[25000]


        ///
        /////
        ///Grouping into Map using groupingBy
        ////
        /////

        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory())));
//{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
// FullStack=[FullStack:14000:91],
// Microservices=[API:22000:97, Microservices:25000:96],
// Framework=[Spring:20000:98, Spring Boot:18000:95]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );//{Cloud=4, FullStack=1, Microservices=2, Framework=2}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );//{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())))
        );
        //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}

////
//
///
//
//higher order functions
//Higher-order functions are functions that either accept other functions as arguments, or return a function as a result.
// The result of one higher-order function can be used as the input to another higher-order function.
// Any time we pass a lambda expression to a method, that method is a higher-order function
        int cutoffReviewScore = 95;

        Predicate<Course> reviewScoreGreaterThan95Predicate2
                = createPredicateWithCutoffReviewScore(cutoffReviewScore);

        Predicate<Course> reviewScoreGreaterThan90Predicate2
                = course -> course.getReviewScore() > 90;

    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }



    //intermediate operations are all lazy in java they return stream
    //java code will compile when the terminal operation happens
}
