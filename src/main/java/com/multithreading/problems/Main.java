package com.multithreading.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(1000000L, 3435L, 35435L, 2324L,
                4656L, 23L, 5556L);
        List<FactorialThread> threads = new ArrayList<>();
        for (Long number : inputNumbers) {
            threads.add(new FactorialThread(number));
        }

        for (FactorialThread thread : threads) {
            thread.start();
        }

        for (FactorialThread thread : threads) {
            thread.join(2000);
        }

        for(FactorialThread thread : threads){
            if(thread.isFinished){
                System.out.println(thread.getResult());
            }else{
                thread.interrupt();
                System.out.println("Couldn't complete calc in 2s");
            }

        }

        for (FactorialThread thread : threads) {
            thread.getState();
        }

        System.out.println("Main is completed!");
    }
}
