package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

//
//    Managing threads manually can be complex and error-prone.
//    It can lead to complex issues like resource contention, thread creation
//    overhead, and scalability challenges.
//    For these reasons, you'll want to use an ExecutorService, even when working
//    with a single thread.

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);//executor requires a

        for (int i = 0; i < 100; i++) {
            executor.execute(new NumberPrinter(i));
        }
        executor.shutdown();
    }


}

class NumberPrinter implements Runnable {
    int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" : " + number);
     //   System.out.println(number);
    }


}
