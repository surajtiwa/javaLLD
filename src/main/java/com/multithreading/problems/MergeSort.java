package com.multithreading.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


public class MergeSort implements Callable<List<Integer>> {

    List<Integer> list;
    ExecutorService executor;

    public MergeSort(List<Integer> list, ExecutorService executor) {
        this.list = list;
        this.executor = executor;
    }

    @Override
    public List<Integer> call() throws Exception {

        if (list.size() <= 1) {
            return list;
        }

        //recursive case
        int n = list.size();
        int mid = n / 2;
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();
        //Division of array into 2 parts
        for (int i = 0; i < n; i++) {
            if (i < mid) {
                leftArr.add(list.get(i));
            } else {
                rightArr.add(list.get(i));
            }
        }
        MergeSort leftSorter = new MergeSort(leftArr, executor);
        MergeSort rightSorter = new MergeSort(rightArr, executor);
        Future<List<Integer>> leftFuture = executor.submit(leftSorter);
        Future<List<Integer>> rightFuture = executor.submit(rightSorter);
        leftArr = leftFuture.get();
        rightArr = rightFuture.get();
        List<Integer> output = merge(leftArr, rightArr);

        return output;
    }

    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> output = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) < rightList.get(j)) {
                output.add(leftList.get(i));
                i++;
            } else {
                output.add(rightList.get(j));
                j++;
            }

        }

        while (i < leftList.size()) {
            output.add(leftList.get(i));
            i++;
        }
        while (j < rightList.size()) {
            output.add(rightList.get(j));
            j++;
        }
        return output;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(2, 1, 4, 5, 3, 8, 16, 9);
        ExecutorService fixedExecutor = Executors.newCachedThreadPool();
        MergeSort mergeSort = new MergeSort(list, fixedExecutor);
        Future<List<Integer>> futureList = fixedExecutor.submit(mergeSort);
        System.out.println(futureList.get());
        fixedExecutor.shutdown();
    }
}
