package com.java.day7;

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}

public class Prog1 {
    public static void main(String[] args) {
        // Create two MyThread objects, representing two threads
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Start the first thread
        t1.start();

        // Start the second thread
        t2.start();
    }
}
