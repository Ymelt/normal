package com.example.normal;

public class SimpleSingleton {

    private static SimpleSingleton instance = new SimpleSingleton();

    public SimpleSingleton() {
    }

    public static SimpleSingleton getInstance(){
//        if (instance == null){
//            return new SimpleSingleton();
//        }
        return instance;
    }

    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];
    }


}
