package functionalprogrammingwithcustomclasses;

public class FP05Threads {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
            }
        };

        //lambda
        Runnable runnable2 = () -> {
            for (int i = 0; i < 10000; i++) { //for loop using stream IntStream.range(0, 10000).forEach(i -> System.out....)
                System.out.println(Thread.currentThread().getId() + ":" + i);
            }
        };

//        Thread thread = new Thread(runnable);
//        thread.start();
//        Thread thread1 = new Thread(runnable);
//        thread1.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }

}



