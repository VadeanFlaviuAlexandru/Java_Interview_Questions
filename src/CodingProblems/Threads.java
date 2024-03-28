package CodingProblems;

public class Threads {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            if (this.isDaemon()) {
                System.out.println("This daemon thread is running");
            } else {
                System.out.println("This thread is running");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.activeCount());
//        Thread.currentThread().setName("MainMain");
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(10);
//        System.out.println(Thread.currentThread().getPriority());
//        System.out.println(Thread.currentThread().isAlive());


//        for (int i = 3; i > 0; i--) {
//            System.out.println(i);
//            Thread.sleep(1000);
//        }
//
//        System.out.println("You are done!");


        // now using the class:


        MyThread thread2 = new MyThread();
        System.out.println(thread2.isDaemon()); // false
        thread2.setDaemon(true);
        System.out.println(thread2.isDaemon()); // now its true
//        System.out.println(thread2.isAlive()); // false
//        thread2.start();
//        System.out.println(thread2.isAlive()); //  now its true
//        System.out.println(thread2.getName());
//        thread2.setName("ThreadSecond");
//        System.out.println(thread2.getName());


    }
}