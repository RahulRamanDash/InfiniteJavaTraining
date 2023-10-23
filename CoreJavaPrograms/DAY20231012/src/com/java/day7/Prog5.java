package com.java.day7;

class SumCalculator extends Thread {
    private int[] numbers;
    private int sum;

    public SumCalculator(int[] numbers) {
        this.numbers = numbers;
        this.sum = 0;
    }

    @Override
    public void run() {
        // Calculate the sum of numbers in the provided array
        for (int num : numbers) {
            sum += num;
        }
    }

    public int getSum() {
        return sum;
    }
}

public class Prog5 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // Create two threads to calculate the sum of the numbers
        SumCalculator thread1 = new SumCalculator(numbers);
        SumCalculator thread2 = new SumCalculator(numbers);

        // Start both threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();

            // Combine the results
            int totalSum = thread1.getSum() + thread2.getSum();
            System.out.println("Sum of numbers: " + totalSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}