package com.forkjoindemo.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComplicatedObject {

    private String name;

    public String work() throws InterruptedException {
        System.out.println("name: " + name);
        Thread.sleep(550);
        System.out.println("eman: " + new StringBuilder(name).reverse());


        return new StringBuilder("name: " + name).append("\n").append("eman: " + new StringBuilder(name).reverse()).toString();

    }
}
