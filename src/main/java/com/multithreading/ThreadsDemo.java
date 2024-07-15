package com.multithreading;

public class ThreadsDemo {

    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            Thread t=new Thread(new NumberPrinter(i));  //with thread we need to create a new thread
            t.start();//we need to start them
        }

    }
}
