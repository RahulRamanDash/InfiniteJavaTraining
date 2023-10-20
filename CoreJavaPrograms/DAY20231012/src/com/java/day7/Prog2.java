package com.java.day7;

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}

public class Prog2 {
    public static void main(String[] args) {
        // Create a MyRunnable object
        MyRunnable myRunnable = new MyRunnable();

        // Create two threads using the MyRunnable object
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        // Start the first thread
        t1.start();

        // Start the second thread
        t2.start();
    }
}
