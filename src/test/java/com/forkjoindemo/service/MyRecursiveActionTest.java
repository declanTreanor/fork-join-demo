package com.forkjoindemo.service;

import com.forkjoindemo.model.ComplicatedObject;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.ForkJoinPool;

class MyRecursiveActionTest {

    @Test
    void compute_withSleep() throws InterruptedException {
        System.out.println("started "+LocalDateTime.now());
        ComplicatedObject obj1 = new ComplicatedObject("1mississippi");
        ComplicatedObject obj2 = new ComplicatedObject("2mississippi");
        ComplicatedObject obj3 = new ComplicatedObject("3mississippi");
        ComplicatedObject obj4 = new ComplicatedObject("4mississippi");
        new ForkJoinPool().execute(new MyRecursiveAction(new ComplicatedObject[]{obj1,obj2,obj3,obj4}));
        Thread.sleep(2000);
        System.out.println("finished "+LocalDateTime.now());
    }

}