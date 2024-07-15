package com.multithreading.problems;

import java.math.BigInteger;

public class FactorialThread extends Thread {

    private long number;
    private BigInteger result;
    boolean isFinished = false;

    FactorialThread(long number) {
        this.number = number;
    }

    @Override
    public void run() {
        result = factorial(number);
        isFinished = true;

    }

    BigInteger factorial(long n) {
        BigInteger ans = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }


    BigInteger getResult() {
        return result;
    }

    boolean isFinished() {
        return isFinished;
    }

}
