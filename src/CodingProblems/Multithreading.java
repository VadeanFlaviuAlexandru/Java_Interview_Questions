package CodingProblems;

public class Multithreading {

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                System.out.println("Thread #2: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread #2 is done.");
        }
    }


    public static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                System.out.println("Thread #1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread #1 is done.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread(); // so method 1 of creating a thread: extends thread

        MyRunnable runnable1 = new MyRunnable(); // method 2 is implementing the runnable
        Thread thread2 = new Thread(runnable1); // and passing it to the Thread class

        thread1.start();
        thread1.join(); // and now this is when thread 2 joins when thread 1 finishes
        thread2.start();
    }
}