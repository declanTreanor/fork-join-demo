package com.forkjoindemo.service;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

class MyRecursiveTaskTest {

    @Test
    public void compute_withSleep() {

        int[] ints = new int[]{1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};

        MyRecursiveTask customRecursiveTask = new MyRecursiveTask(ints);
        int result = new ForkJoinPool().invoke(customRecursiveTask);
        System.out.println(result);
    }

}