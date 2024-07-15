package adderSubtractor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Count count=new Count();
        Lock lock = new ReentrantLock();
        Adder adder=new Adder(count,lock);
        Subtractor subtractor=new Subtractor(count,lock);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(adder);
        executorService.execute(subtractor);
        executorService.shutdown();
        System.out.println(count.value);

    }
}
