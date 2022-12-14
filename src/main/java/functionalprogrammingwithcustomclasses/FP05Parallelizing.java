package functionalprogrammingwithcustomclasses;

import java.util.stream.LongStream;

public class FP05Parallelizing {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        //0 , 1000000 add numbers of the list
    //    System.out.println(LongStream.range(0, 1000000000).sum());
        //499999999500000000
        //2116

        System.out.println(LongStream.range(0, 1000000000).parallel().sum());
        //499999999500000000
        //246

        System.out.println(System.currentTimeMillis() - time);
    }
}
