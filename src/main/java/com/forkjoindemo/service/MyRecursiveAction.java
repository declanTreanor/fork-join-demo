package com.forkjoindemo.service;

import com.forkjoindemo.model.ComplicatedObject;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    private ComplicatedObject[] complicatedObjects;

    public MyRecursiveAction(ComplicatedObject[]  complicatedObjects) {
        this.complicatedObjects = complicatedObjects;
    }

    public void adddComplicatedObject(ComplicatedObject obj){
        if(complicatedObjects != null){
            complicatedObjects[complicatedObjects.length-1] = obj;

        } else throw new RuntimeException("booom!");
    }

    @SneakyThrows
    @Override
    protected void compute() {
        if (complicatedObjects.length > 1) {
            ForkJoinTask.invokeAll(createSubtasks());
        } else {
            processing(complicatedObjects[0]);
        }
    }

    private List<MyRecursiveAction> createSubtasks() {
        List<MyRecursiveAction> subtasks = new ArrayList<>();
        for(ComplicatedObject obj:complicatedObjects){
                subtasks.add(new MyRecursiveAction(new ComplicatedObject[]{obj}));

        }

        return subtasks;
    }

    private void processing(ComplicatedObject obj) throws InterruptedException {
       // Thread.sleep(1000);
        System.out.println("This result - (" + obj.work() + ") - was processed by "
                + Thread.currentThread().getName());
        System.out.println(""+LocalDateTime.now());
    }
}