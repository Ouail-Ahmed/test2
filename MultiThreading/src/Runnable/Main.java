package Runnable;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new MyRunnable1());
        Thread t2 = new Thread(new MyRunnable2());
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 3: "+ i);

                }
            }
        });
        t1.start();
        t1.join();
        t2.start();
    }

    static class MyRunnable1 implements Runnable {

        @Override
        public void run(){
            for (int i = 0; i < 5 ; i++) {
                System.out.println("Thread 1: " + i);
            }
        }
    }
    static class MyRunnable2 implements Runnable {

        @Override
        public void run(){
            for (int i = 0; i < 5 ; i++) {
                System.out.println("Thread 2: " + i);
            }
        }
    }
}
