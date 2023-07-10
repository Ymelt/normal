package com.example.normal.pojo;

public class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("is going");
        System.out.println("this is " + Thread.currentThread().getName());
    }
}
