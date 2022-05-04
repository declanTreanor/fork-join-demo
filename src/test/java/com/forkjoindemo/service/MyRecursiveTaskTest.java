package com.forkjoindemo.service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

class MyRecursiveTaskTest {

    @Test
    public void compute_withSleep() {

        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10,10000000,2,3,4,5,6,7,8,9,10,};

        MyRecursiveTask customRecursiveTask = new MyRecursiveTask(ints);
        int result = new ForkJoinPool().invoke(customRecursiveTask);
        System.out.println(result);
    }

}